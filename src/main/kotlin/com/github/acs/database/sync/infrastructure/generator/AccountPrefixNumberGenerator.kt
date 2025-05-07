package com.github.acs.database.sync.infrastructure.generator

import com.github.acs.database.sync.infrastructure.persistence.AccountEntity
import org.hibernate.engine.spi.SharedSessionContractImplementor


class AccountPrefixNumberGenerator: PrefixNumberGenerator() {

    override fun getPrefix(): String {
        return "ACC-"
    }

    override fun generate(
        session: SharedSessionContractImplementor?,
        `object`: Any?
    ): Any? {
        if(this.allowAssignedIdentifiers() && `object` is AccountEntity) {
            return `object`.accountNumber.toString()
        }
        return this.generateCustomNumber(session, `object`)
    }

    override fun allowAssignedIdentifiers(): Boolean {
        return true
    }
}