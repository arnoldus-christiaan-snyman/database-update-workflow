package com.github.acs.database.sync.application.port.output

interface EntityPersistencePort<T> {

    fun saveEntity(entity: T): T

}