package com.github.acs.database.sync.application.port.input

interface DatabaseEventHandler<T> {

    fun handleChangeEvent(changeEvent: T): Unit

}