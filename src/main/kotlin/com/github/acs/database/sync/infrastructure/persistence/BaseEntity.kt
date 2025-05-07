package com.github.acs.database.sync.infrastructure.persistence

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@MappedSuperclass
abstract class BaseEntity(
    @get:Column(nullable = false)
    var isActive: Boolean = true,

    @get:Id
    @get:GeneratedValue(strategy = GenerationType.IDENTITY)
    @get:Column(nullable = false, updatable = false)
    var id: Long? = null,

    @get:CreationTimestamp
    @get:Column(nullable = false, updatable = false)
    var createdAt: Timestamp? = null,

    @get:UpdateTimestamp
    @get:Column(nullable = false)
    var updatedAt: Timestamp? = null,

    @get:Version
    @get:Column(nullable = false)
    var version: Long? = null,

)