package com.github.acs.database.sync.domain.factory

interface ModelFactory<T> {
    fun createEntity(entity: T): T
    fun updateEntity(entity: T): T
}