package com.github.acs.database.sync.domain.model

import java.math.BigDecimal
import java.util.Currency

data class ProviderDTO (
    val companyNumber: Long,
    val name: String,
    val address: AddressDTO,
    val phone: String,
    val email: String,
    val website: String,
    val validDomainTypes: Set<DomainType> = emptySet(),
    val rates: Map<String, BigDecimal> = emptyMap(),
    val currency: Currency,
    val vatPercentage: BigDecimal,
    val isActive: Boolean = true,
)