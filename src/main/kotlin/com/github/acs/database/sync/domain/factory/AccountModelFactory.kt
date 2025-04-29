package com.github.acs.database.sync.domain.factory

import com.github.acs.database.sync.domain.model.AccountDTO

class AccountModelFactory : ModelFactory<AccountDTO> {
    override fun createEntity(entity: AccountDTO): AccountDTO {
        // Logic to create a new account entity
        return entity
    }

    override fun updateEntity(entity: AccountDTO): AccountDTO {
        // Logic to update an existing account entity
        return entity
    }
}