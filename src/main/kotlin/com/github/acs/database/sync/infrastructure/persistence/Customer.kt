package com.github.acs.database.sync.infrastructure.persistence

import jakarta.persistence.*
import java.sql.Date

@Entity
data class Customer(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val email: String,
    val dateOfBirth: Date,
    val nationality: String,
    val telephone: String? = null,
    val mobile: String,
    val fax: String? = null,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    val address: Address,

    @OneToMany(mappedBy = "customer", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    val accounts: Set<Account> = emptySet(),

) : BaseEntity()
