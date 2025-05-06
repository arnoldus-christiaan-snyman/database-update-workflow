package com.github.acs.database.sync.application.port.output

interface EntitySearchPort<T> {

    fun findEntityById(id: Long): T?

    fun findEntitiesByField(fieldName: String, fieldValue: Any): Set<T>?

    fun findAllEntities(): Set<T>

}