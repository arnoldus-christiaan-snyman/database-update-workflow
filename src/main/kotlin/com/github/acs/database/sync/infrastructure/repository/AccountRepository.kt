package com.github.acs.database.sync.infrastructure.repository

import com.github.acs.database.sync.infrastructure.persistence.AccountEntity
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: BaseRepository<AccountEntity> {
}