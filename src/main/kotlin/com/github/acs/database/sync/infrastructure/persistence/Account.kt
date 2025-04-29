package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.domain.model.DomainType
import jakarta.persistence.*

@Entity
data class Account(
    val accountNumber: Number,
    val isBlocked: Boolean = false,
    val blockedReason: String? = null,

    @Enumerated(EnumType.STRING)
    val domainType: DomainType,

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val meters: Set<Meter> = emptySet(),

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    val customer: Customer,

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    val provider: Provider,

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val usage: Set<Usage> = emptySet(),

) : BaseEntity()
