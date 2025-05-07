package com.github.acs.database.sync.infrastructure.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BaseRepository<E>: CrudRepository<E, Long> {
}