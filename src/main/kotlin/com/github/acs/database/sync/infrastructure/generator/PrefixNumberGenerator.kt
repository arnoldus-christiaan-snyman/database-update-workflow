package com.github.acs.database.sync.infrastructure.generator

import org.hibernate.engine.spi.SharedSessionContractImplementor
import org.hibernate.id.enhanced.SequenceStyleGenerator

abstract class PrefixNumberGenerator: SequenceStyleGenerator() {

    companion object {
        const val DEFAULT_NUMBER_LENGTH = 10
    }

    protected abstract fun getPrefix(): String
    protected fun getNumberLength(): Int? = DEFAULT_NUMBER_LENGTH

    protected fun generateCustomNumber(
        session: SharedSessionContractImplementor?,
        `object`: Any?
    ): String {
        val customIdTemplate = "${this.getPrefix()}%0${this.getNumberLength()}d"
        return String.format(customIdTemplate, super.generate(session, `object`))
    }

}