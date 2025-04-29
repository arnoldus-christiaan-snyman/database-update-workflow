package com.github.acs.database.sync.infrastructure.adapter.outbound

import com.github.acs.database.sync.application.port.output.ChangePublisherPort
import com.github.acs.database.sync.domain.container.DatabaseChangeContainer
import com.github.acs.database.sync.domain.factory.ModelFactoryFinder
import org.springframework.stereotype.Component

@Component
class KafkaChangePublisher : ChangePublisherPort {
    override fun publishChange(databaseChangeContainer: DatabaseChangeContainer) {
        val modelFactory = ModelFactoryFinder.findModelFactory(databaseChangeContainer.table);
    }

    override fun publishDelete(databaseChangeContainer: DatabaseChangeContainer) {
        val modelFactory = ModelFactoryFinder.findModelFactory(databaseChangeContainer.table);
    }
}