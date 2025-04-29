package com.github.acs.database.sync.domain.model.meter

data class MeterDTO(
    val serialNumber: String,
    val brand: BrandDTO,
    val hardwareVersion: String = "1.0",
    val firmwareVersion: String? = null,
    val isActive: Boolean = true,
    )
