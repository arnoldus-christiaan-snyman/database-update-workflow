package com.github.acs.database.sync.domain.model

data class AddressDTO (
    val streetName: String,
    val houseNumber: String,
    val additionalAddressInfo: String? = null,
    val postalCode: String,
    val city: String,
    val state: String? = null,
    val country: String,
    val addressType: AddressType,
    val geometryDTO: GeometryDTO? = null,
)