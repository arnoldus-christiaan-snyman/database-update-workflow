package com.github.acs.database.sync.infrastructure.adapter.outbound

import com.github.acs.database.sync.application.port.output.ChangePublisherPort
import com.github.acs.database.sync.domain.container.DatabaseChangeContainer
import com.github.acs.database.sync.domain.factory.ModelFactory
import com.github.acs.database.sync.domain.factory.ModelFactoryFinder

abstract class ChangePublisherAdapter: ChangePublisherPort {

    protected var modelFactory: ModelFactory<*>? = null

    protected fun setModelFactory(databaseChangeContainer: DatabaseChangeContainer): Unit {
        this.modelFactory = ModelFactoryFinder.findModelFactory(databaseChangeContainer.table)
    }

}