package com.github.acs.database.sync.application.port.input

import io.debezium.engine.RecordChangeEvent

interface DatabaseEventHandler<T> {

    fun handleChangeEvent(changeEvent: T): Unit

}