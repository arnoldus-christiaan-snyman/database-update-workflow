package com.github.acs.database.sync.domain.model

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID

data class UsageDTO(
    val reference: UUID,
    val calculatedRate: BigDecimal,
    val quantity: Int,
    val calculatedTax: BigDecimal,
    val calculatedTotalTaxExcluded: BigDecimal,
    val calculatedTotalTaxIncluded: BigDecimal,
    val isPaid: Boolean = false,
    val paidOn: LocalDateTime? = null,
    val calculatedOn: LocalDateTime = LocalDateTime.now(),
)
