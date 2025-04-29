package com.github.acs.database.sync.infrastructure.persistence

import jakarta.persistence.*

@Entity
data class Meter(
    val serialNumber: String,
    val hardwareVersion: String = "1.0",
    val firmwareVersion: String? = null,

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account,

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    val brand: Brand,
) : BaseEntity()
