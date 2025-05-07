package com.github.acs.database.sync.infrastructure.persistence

import com.github.acs.database.sync.infrastructure.annotation.generator.CustomerNumberId
import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Past
import java.sql.Date

@Entity
@Table(name = "CUSTOMER")
data class CustomerEntity(
    @get:Id
    @get:CustomerNumberId
    @get:Column(nullable = false, updatable = false, unique = true)
    var customerNumber: String?,

    @get:NotBlank(message = "First name is mandatory")
    @get:Column(nullable = false)
    val firstName: String,

    @get:NotBlank(message = "Last name is mandatory")
    @get:Column(nullable = false)
    val lastName: String,

    @get:NotBlank(message = "Gender is mandatory")
    @get:Column(nullable = false)
    val gender: String,

    @get:NotBlank(message = "Email is mandatory")
    @get:Email(message = "Email is invalid")
    @get:Column(nullable = false)
    val email: String,

    @get:NotBlank(message = "Date of birth is mandatory")
    @get:Past(message = "Date of birth must be in the past")
    @get:Column(nullable = false)
    val dateOfBirth: Date,

    @get:NotBlank(message = "Date of birth is mandatory")
    @get:Column(nullable = false)
    val nationality: String,

    val telephone: String? = null,

    @get:NotBlank(message = "Mobile number is mandatory")
    @get:Column(nullable = false)
    val mobile: String,

    val fax: String? = null,

    @get:OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    @get:JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    @get:Column(nullable = false)
    val address: AddressEntity,

    @get:OneToMany(mappedBy = "CUSTOMER", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    @get:Column(nullable = false)
    val accounts: Set<AccountEntity>? = emptySet(),

    ) : BaseEntity()
