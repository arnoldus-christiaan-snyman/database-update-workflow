package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.domain.model.DomainType
import com.github.acs.database.sync.infrastructure.annotation.generator.AccountNumberId
import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "ACCOUNT")
data class AccountEntity(
    @get:Id
    @get:AccountNumberId
    @get:Column(nullable = false, updatable = false, unique = true)
    var accountNumber: String?,

    @get:Column(nullable = false)
    val isBlocked: Boolean = false,

    val blockedReason: String? = null,

    @get:NotNull(message = "Domain type is mandatory")
    @get:Enumerated(EnumType.STRING)
    @get:Column(nullable = false)
    val domainType: DomainType,

    @get:NotEmpty(message = "At least one meter is required")
    @get:OneToMany(mappedBy = "account", orphanRemoval = true, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @get:Column(nullable = false)
    val meters: Set<MeterEntity> = emptySet(),

    @get:NotNull(message = "An account has to be assigned to a customer")
    @get:ManyToOne
    @get:JoinColumn(name = "customer_id", nullable = false)
    @get:Column(nullable = false, updatable = false)
    val customer: CustomerEntity,

    @get:NotNull(message = "An provider needs to be assigned to an account")
    @get:ManyToOne
    @get:JoinColumn(name = "provider_id", nullable = false)
    @get:Column(nullable = false)
    val provider: ProviderEntity,

    @get:OneToMany(mappedBy = "account", orphanRemoval = true, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @get:Column(nullable = false)
    val usage: Set<UsageEntity>? = emptySet(),

    ) : BaseEntity()
