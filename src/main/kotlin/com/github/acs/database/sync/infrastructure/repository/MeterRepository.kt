package com.github.acs.database.sync.infrastructure.repository

import com.github.acs.database.sync.infrastructure.persistence.MeterEntity
import org.springframework.stereotype.Repository

@Repository
interface MeterRepository: BaseRepository<MeterEntity> {
}