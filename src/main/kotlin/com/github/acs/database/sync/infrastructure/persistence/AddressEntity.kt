package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.domain.model.AddressType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

@Entity
@Table(name = "ADDRESS")
data class AddressEntity(
    @get:NotBlank(message = "Street name is mandatory")
    @get:Column(nullable = false)
    val streetName: String,

    @get:NotBlank(message = "House number is mandatory")
    @get:Column(nullable = false)
    val houseNumber: String,

    val additionalAddressInfo: String? = null,

    @get:NotBlank(message = "Postal code is mandatory")
    @get:Column(nullable = false)
    val postalCode: String,

    @get:NotBlank(message = "City is mandatory")
    @get:Column(nullable = false)
    val city: String,

    val state: String? = null,

    @get:NotBlank(message = "Country is mandatory")
    @get:Column(nullable = false)
    val country: String,

    val longitude: BigDecimal? = null,

    val latitude: BigDecimal? = null,

    @get:NotBlank(message = "Address type is mandatory")
    @get:Enumerated(EnumType.STRING)
    @get:Column(nullable = false)
    val addressType: AddressType,

    ) : BaseEntity()
