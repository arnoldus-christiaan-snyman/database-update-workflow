package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.domain.model.DomainType
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Provider(
    val companyNumber: Long,
    val name: String,
    val phone: String,
    val email: String,
    val website: String,
    val currencyCode: String,
    val vatPercentage: BigDecimal,

    @OneToMany(mappedBy = "provider", orphanRemoval = true, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val account: Account,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    val address: Address,

    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
        name = "provider_domain_types",
        joinColumns = [JoinColumn(name = "provider_id")]
    )
    @Column(name = "validDomainType")
    val validDomainTypes: Set<DomainType> = emptySet(),

    @ElementCollection
    @CollectionTable(
        name = "provider_rates",
        joinColumns = [JoinColumn(name = "provider_id")]
    )
    @MapKeyColumn(name = "rate_category")
    @Column(name = "rate_value")
    val rates: Map<String, BigDecimal> = emptyMap(),

    ) : BaseEntity()
