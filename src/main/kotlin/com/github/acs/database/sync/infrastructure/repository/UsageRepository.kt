package com.github.acs.database.sync.infrastructure.repository

import com.github.acs.database.sync.infrastructure.persistence.UsageEntity
import org.springframework.stereotype.Repository

@Repository
interface UsageRepository: BaseRepository<UsageEntity> {
}