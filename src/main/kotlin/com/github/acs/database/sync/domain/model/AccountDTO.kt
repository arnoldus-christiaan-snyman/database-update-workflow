package com.github.acs.database.sync.domain.model

import com.github.acs.database.sync.domain.model.meter.MeterDTO

data class AccountDTO(
    val accountNumber: Number,
    val domainType: DomainType,
    val meters: Set<MeterDTO> = emptySet(),
    val customer: CustomerDTO,
    val provider: ProviderDTO,
    val usage: Set<UsageDTO> = emptySet(),
    val isBlocked: Boolean = false,
    val blockedReason: String? = null,
    val isActive: Boolean = true,
)
