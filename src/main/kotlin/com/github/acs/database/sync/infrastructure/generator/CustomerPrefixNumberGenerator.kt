package com.github.acs.database.sync.infrastructure.generator

import com.github.acs.database.sync.infrastructure.persistence.CustomerEntity
import org.hibernate.engine.spi.SharedSessionContractImplementor

class CustomerPrefixNumberGenerator: PrefixNumberGenerator() {

    override fun getPrefix(): String {
        return "CUS-"
    }

    override fun generate(
        session: SharedSessionContractImplementor?,
        `object`: Any?
    ): Any? {
        if(this.allowAssignedIdentifiers() && `object` is CustomerEntity) {
            return `object`.customerNumber.toString()
        }
        return this.generateCustomNumber(session, `object`)
    }

    override fun allowAssignedIdentifiers(): Boolean {
        return true
    }

}