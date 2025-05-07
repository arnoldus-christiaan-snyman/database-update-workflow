package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.domain.model.DomainType
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import org.hibernate.validator.constraints.URL
import java.math.BigDecimal

@Entity
@Table(name = "PROVIDER")
data class ProviderEntity(
    @get:NotBlank(message = "Company number is mandatory")
    @get:Column(nullable = false, unique = true)
    val companyNumber: Long,

    @get:NotBlank(message = "Name is mandatory")
    @get:Column(nullable = false)
    val name: String,

    @get:NotBlank(message = "Phone number is mandatory")
    @get:Column(nullable = false, unique = true)
    val phone: String,

    @get:NotBlank(message = "Email is mandatory")
    @get:Email
    @get:Column(nullable = false, unique = true)
    val email: String,

    @get:NotBlank(message = "Company website URL is mandatory")
    @get:URL(message = "Invalid website URL")
    @get:Column(nullable = false, unique = true)
    val website: String,

    @get:NotBlank(message = "Currency code is mandatory")
    @get:Size(min = 3, max = 3, message = "Currency code must be 3 characters long")
    @get:Column(nullable = false)
    val currencyCode: String,

    @get:NotBlank(message = "Vat percentage is mandatory")
    @get:Column(nullable = false)
    val vatPercentage: BigDecimal,

    @get:OneToMany(mappedBy = "PROVIDER", orphanRemoval = true, cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @get:Column(nullable = false)
    val account: AccountEntity? = null,

    @get:NotNull(message = "Address is mandatory")
    @get:OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    @get:JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    @get:Column(nullable = false)
    val address: AddressEntity,

    @get:NotEmpty(message = "At least one domain type is required")
    @get:ElementCollection(fetch = FetchType.LAZY)
    @get:Enumerated(EnumType.STRING)
    @get:CollectionTable(
        name = "PROVIDER_VALID_DOMAIN_TYPE",
        joinColumns = [JoinColumn(name = "PROVIDER_ID")]
    )
    @get:Column(name = "VALID_DOMAIN_TYPE", nullable = false)
    val validDomainTypes: Set<DomainType>? = emptySet(),

    @get:NotEmpty(message = "At least one rate is required")
    @get:ElementCollection
    @get:CollectionTable(
        name = "PROVIDER_RATE",
        joinColumns = [JoinColumn(name = "PROVIDER_ID")]
    )
    @get:MapKeyColumn(name = "RATE_CATEGORY")
    @get:Column(name = "RATE_VALUE", nullable = false)
    val rates: Map<String, BigDecimal>? = emptyMap(),

    ) : BaseEntity()
