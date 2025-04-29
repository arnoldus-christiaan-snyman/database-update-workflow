package com.github.acs.database.sync.application.port.output

import com.github.acs.database.sync.domain.container.DatabaseChangeContainer

interface ChangePublisherPort {

    fun publishChange(databaseChangeContainer: DatabaseChangeContainer) : Unit
    fun publishDelete(databaseChangeContainer: DatabaseChangeContainer) : Unit

}