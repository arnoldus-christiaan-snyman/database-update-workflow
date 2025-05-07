package com.github.acs.database.sync.infrastructure.repository

import com.github.acs.database.sync.infrastructure.persistence.BrandEntity
import org.springframework.stereotype.Repository

@Repository
interface BrandRepository: BaseRepository<BrandEntity> {
}