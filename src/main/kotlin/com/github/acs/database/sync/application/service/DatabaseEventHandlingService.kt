package com.github.acs.database.sync.application.service

import com.github.acs.database.sync.application.port.input.DatabaseEventHandler
import com.github.acs.database.sync.application.port.output.ChangePublisherPort
import com.github.acs.database.sync.domain.container.DatabaseChangeContainer
import com.github.acs.database.sync.domain.container.DatabaseChangeContainerBuilder
import com.github.acs.database.sync.domain.factory.ModelFactoryFinder
import io.debezium.data.Envelope
import io.debezium.data.Envelope.FieldName.*
import io.debezium.embedded.Connect
import io.debezium.engine.DebeziumEngine
import io.debezium.engine.RecordChangeEvent
import io.debezium.engine.format.ChangeEventFormat
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import jakarta.transaction.Transactional
import org.apache.kafka.connect.data.Struct
import org.apache.kafka.connect.source.SourceRecord
import org.springframework.stereotype.Service
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

typealias DebeziumConfiguration = io.debezium.config.Configuration

@Service
class DatabaseEventHandlingService(
    private val changePublisherPort: ChangePublisherPort,
    private val debeziumConnector: DebeziumConfiguration,
) : DatabaseEventHandler<RecordChangeEvent<SourceRecord>> {

    private val log = org.slf4j.LoggerFactory.getLogger(DatabaseEventHandlingService::class.java)

    private lateinit var debeziumEngine: DebeziumEngine<RecordChangeEvent<SourceRecord>>
    private lateinit var executor: ExecutorService

    @Transactional
    override fun handleChangeEvent(changeEvent: RecordChangeEvent<SourceRecord>) {
        val dataContainer = extractDataFromSourceRecord(changeEvent.record())


        if(dataContainer.operation != Envelope.Operation.READ) {
            when(dataContainer.operation) {
                Envelope.Operation.CREATE -> createEntity(dataContainer)
                Envelope.Operation.UPDATE -> updateEntity(dataContainer)
                Envelope.Operation.DELETE -> deleteEntity(dataContainer)
                else -> log.warn("Operation not supported: ${dataContainer.operation}")
            }
        }

    }

    fun createEntity(dataContainer: DatabaseChangeContainer) {
        log.info("Handling create event: ${dataContainer.operation}, key: ${dataContainer.key}")
        changePublisherPort.publishChange(dataContainer)
    }

    fun updateEntity(dataContainer: DatabaseChangeContainer) {
        log.info("Handling change event: ${dataContainer.operation}, key: ${dataContainer.key}, before: ${dataContainer.before}, after: ${dataContainer.after}")
        changePublisherPort.publishChange(dataContainer)
    }

    fun deleteEntity(dataContainer: DatabaseChangeContainer) {
        log.info("Handling delete event: ${dataContainer.operation}, key: ${dataContainer.key}")
        changePublisherPort.publishDelete(dataContainer)
    }

    fun extractDataFromSourceRecord(sourceRecord: SourceRecord): DatabaseChangeContainer {
        val builder : DatabaseChangeContainerBuilder = DatabaseChangeContainerBuilder()

        builder.key = sourceRecord.key() as String
        builder.after = (sourceRecord.value() as Struct).get(AFTER) as String
        builder.before = (sourceRecord.value() as Struct).get(BEFORE) as String

        val source = (sourceRecord.value() as Struct).get(SOURCE) as Struct
        builder.schema = source.get("schema") as String
        builder.database = source.get("db") as String
        builder.table = source.get("table") as String
        builder.operation = Envelope.Operation.forCode(source.get(OPERATION) as String)

        return builder.build()
    }

    @PostConstruct
    private fun start() : Unit {
        this.executor = Executors.newVirtualThreadPerTaskExecutor()
        this.debeziumEngine = DebeziumEngine.create(ChangeEventFormat.of(Connect::class.java))
            .using(this.debeziumConnector.asProperties())
            .notifying(this::handleChangeEvent)
            .build()
        this.executor.execute(debeziumEngine)
        log.info("Debezium engine started")
    }

    @PreDestroy
    private fun stop() {
        this.debeziumEngine.close()
        this.executor.shutdown()
    }

}