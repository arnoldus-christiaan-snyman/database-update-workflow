package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.domain.model.DomainType
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name = "BRAND")
data class BrandEntity(
    @get:NotBlank(message = "Brand name is mandatory")
    @get:Column(nullable = false)
    val name: String,

    val description: String? = null,

    val manufacturer: String? = null,

    val model: String? = null,

    @get:OneToMany(mappedBy = "BRAND", orphanRemoval = true, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @get:Column(nullable = false)
    val meter: MeterEntity,

    @get:Enumerated(EnumType.STRING)
    @get:Column(nullable = false)
    val domainType: DomainType,

    ) : BaseEntity()
