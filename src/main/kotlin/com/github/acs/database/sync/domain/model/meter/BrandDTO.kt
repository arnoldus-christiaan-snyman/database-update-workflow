package com.github.acs.database.sync.domain.model.meter

import com.github.acs.database.sync.domain.model.DomainType

data class BrandDTO(
    val name: String,
    val domainType: DomainType,
    val description: String? = null,
    val manufacturer: String? = null,
    val model: String? = null,
)
