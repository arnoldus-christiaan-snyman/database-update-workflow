package com.github.acs.database.sync.infrastructure.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "debezium.connector")
data class DebeziumConnectorProperties(
    val topicPrefix: String = "cdc_",
    val name: String = "debezium-connector",
    val clazz: String,
    val custom: Map<String, String> = emptyMap()
)
