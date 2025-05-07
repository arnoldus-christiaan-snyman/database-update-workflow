package com.github.acs.database.sync.infrastructure.repository

import com.github.acs.database.sync.infrastructure.persistence.ProviderEntity
import org.springframework.stereotype.Repository

@Repository
interface ProviderRepository: BaseRepository<ProviderEntity> {
}