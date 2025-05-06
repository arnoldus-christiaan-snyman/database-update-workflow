package com.github.acs.database.sync.infrastructure.adapter.outbound

import com.github.acs.database.sync.domain.container.DatabaseChangeContainer
import org.springframework.stereotype.Component

@Component
class ActiveMqChangePublisherAdapter : ChangePublisherAdapter() {

    override fun publishInsert(databaseChangeContainer: DatabaseChangeContainer): Unit {
        setModelFactory(databaseChangeContainer)
    }

    override fun publishChange(databaseChangeContainer: DatabaseChangeContainer): Unit {
        setModelFactory(databaseChangeContainer)
    }

    override fun publishDelete(databaseChangeContainer: DatabaseChangeContainer): Unit {
        setModelFactory(databaseChangeContainer)
    }

}