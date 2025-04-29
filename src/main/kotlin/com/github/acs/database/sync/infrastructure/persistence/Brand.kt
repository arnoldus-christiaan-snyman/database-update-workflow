package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.domain.model.DomainType
import jakarta.persistence.*

@Entity
data class Brand(
    val name: String,
    val description: String? = null,
    val manufacturer: String? = null,
    val model: String? = null,

    @OneToMany(mappedBy = "brand", orphanRemoval = true, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val meter: Meter,

    @Enumerated(EnumType.STRING)
    val domainType: DomainType,

) : BaseEntity()
