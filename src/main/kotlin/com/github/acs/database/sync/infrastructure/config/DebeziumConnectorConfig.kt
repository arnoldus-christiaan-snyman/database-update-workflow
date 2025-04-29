package com.github.acs.database.sync.infrastructure.config

import com.github.acs.database.sync.infrastructure.config.properties.DebeziumConnectorProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

typealias DebeziumConfiguration = io.debezium.config.Configuration

@Configuration
class DebeziumConnectorConfig(
    val debeziumConnectorProperties: DebeziumConnectorProperties,
) {

    @Bean
    fun debeziumConnector(): DebeziumConfiguration {
        val debeziumConnectorBuilder = DebeziumConfiguration.create()
            .with("topic.prefix", debeziumConnectorProperties.topicPrefix)
            .with("name", debeziumConnectorProperties.name)
            .with("connector.class", debeziumConnectorProperties.clazz)

        debeziumConnectorProperties.custom.forEach { (key, value) ->
            debeziumConnectorBuilder.with(key, value)
        }

        return debeziumConnectorBuilder.build();
    }

}