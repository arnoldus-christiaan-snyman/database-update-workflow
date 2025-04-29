package com.github.acs.database.sync.domain.factory

import com.github.acs.database.sync.domain.model.ProviderDTO

class ProviderModelFactory : ModelFactory<ProviderDTO> {
    override fun createEntity(entity: ProviderDTO): ProviderDTO {
        // Implement the logic to create a new Provider entity
        return entity
    }

    override fun updateEntity(entity: ProviderDTO): ProviderDTO {
        // Implement the logic to update an existing Provider entity
        return entity
    }
}