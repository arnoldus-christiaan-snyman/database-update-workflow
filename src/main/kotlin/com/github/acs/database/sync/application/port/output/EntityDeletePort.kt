package com.github.acs.database.sync.application.port.output

interface EntityDeletePort<T> {

    fun deleteEntity(entity: T): Unit

}