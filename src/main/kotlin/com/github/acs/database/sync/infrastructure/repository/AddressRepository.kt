package com.github.acs.database.sync.infrastructure.repository

import com.github.acs.database.sync.infrastructure.persistence.AddressEntity
import org.springframework.stereotype.Repository

@Repository
interface AddressRepository: BaseRepository<AddressEntity> {
}