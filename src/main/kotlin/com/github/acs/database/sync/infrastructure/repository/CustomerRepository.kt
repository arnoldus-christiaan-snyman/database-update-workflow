package com.github.acs.database.sync.infrastructure.repository

import com.github.acs.database.sync.infrastructure.persistence.CustomerEntity
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: BaseRepository<CustomerEntity> {

}