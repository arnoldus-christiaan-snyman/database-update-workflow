package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.domain.model.AddressType
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import java.math.BigDecimal

@Entity
data class Address(
    val streetName: String,
    val houseNumber: String,
    val additionalAddressInfo: String? = null,
    val postalCode: String,
    val city: String,
    val state: String? = null,
    val country: String,
    val longitude: BigDecimal? = null,
    val latitude: BigDecimal? = null,

    @Enumerated(EnumType.STRING)
    val addressType: AddressType,

    ) : BaseEntity()
