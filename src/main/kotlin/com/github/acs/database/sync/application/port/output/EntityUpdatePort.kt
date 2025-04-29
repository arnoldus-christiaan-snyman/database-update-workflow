package com.github.acs.database.sync.application.port.output

interface EntityUpdatePort<T> {

    fun updateEntity(entity: T): T

}