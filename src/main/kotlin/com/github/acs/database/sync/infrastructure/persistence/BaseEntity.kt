package com.github.acs.database.sync.infrastructure.persistence

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@MappedSuperclass
abstract class BaseEntity(
    var isActive: Boolean = true,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    var createdAt: Timestamp? = null,

    @UpdateTimestamp
    @Column(nullable = false)
    var updatedAt: Timestamp? = null,

    @Version
    var version: Long? = null,

)