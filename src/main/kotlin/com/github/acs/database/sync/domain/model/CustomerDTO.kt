package com.github.acs.database.sync.domain.model

import com.github.acs.database.sync.domain.model.address.AddressDTO
import java.time.LocalDate

data class CustomerDTO(
    val firstName: String,
    val lastName: String,
    val gender: Gender,
    val email: String,
    val dateOfBirth: LocalDate,
    val nationality: String,
    val telephone: String? = null,
    val mobile: String,
    val fax: String? = null,
    val address: AddressDTO,
    val accounts: Set<AccountDTO> = emptySet(),
)
