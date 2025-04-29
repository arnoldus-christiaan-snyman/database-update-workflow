package com.github.acs.database.sync.domain.container

import io.debezium.data.Envelope

data class DatabaseChangeContainerBuilder(
    var key: String = "",
    var before: String? = "",
    var after: String? = "",
    var schema: String = "",
    var database: String = "",
    var operation: Envelope.Operation = Envelope.Operation.READ,
    var table: String = ""
) {
    fun build(): DatabaseChangeContainer {
        return DatabaseChangeContainer(
            key = key,
            before = before,
            after = after,
            schema = schema,
            database = database,
            operation = operation,
            table = table
        )
    }
}