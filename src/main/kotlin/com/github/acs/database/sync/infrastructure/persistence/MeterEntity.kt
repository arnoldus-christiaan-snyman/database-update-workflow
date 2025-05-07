package com.github.acs.database.sync.infrastructure.persistence

import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "METER")
data class MeterEntity(
    @get:NotBlank(message = "Serial number is mandatory")
    @get:Column(nullable = false, updatable = false, unique = true)
    val serialNumber: String,
    val hardwareVersion: String? = null,
    val firmwareVersion: String? = null,

    @get:NotNull("A meter needs to be assigned to an account")
    @get:ManyToOne
    @get:JoinColumn(name = "ACCOUNT_ID", nullable = false)
    @get:Column(nullable = false)
    val account: AccountEntity,

    @get:NotNull("A meter needs to be of a specific brand")
    @get:ManyToOne
    @get:JoinColumn(name = "BRAND_ID", nullable = false)
    @get:Column(nullable = false)
    val brand: BrandEntity,
) : BaseEntity()
