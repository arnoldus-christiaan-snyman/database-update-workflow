package com.github.acs.database.sync.domain.container

import io.debezium.data.Envelope

data class DatabaseChangeContainer(
    val key: String,
    val before: String?,
    val after: String?,
    val schema: String,
    val database: String,
    val operation: Envelope.Operation,
    val table: String,
)
