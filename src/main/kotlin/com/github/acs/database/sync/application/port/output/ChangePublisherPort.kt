package com.github.acs.database.sync.application.port.output

import com.github.acs.database.sync.domain.container.DatabaseChangeContainer

interface ChangePublisherPort {
    fun publishInsert(databaseChangeContainer: DatabaseChangeContainer) : Unit
    fun publishChange(databaseChangeContainer: DatabaseChangeContainer) : Unit
    fun publishDelete(databaseChangeContainer: DatabaseChangeContainer) : Unit
}