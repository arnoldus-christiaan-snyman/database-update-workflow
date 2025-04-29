package com.github.acs.database.sync.application.port.output

interface EntitySearchPort<T> {

    fun findEntityById(id: Long): T?

    fun findEntityByField(fieldName: String, fieldValue: String): T?

    fun findAllEntities(): List<T>

}