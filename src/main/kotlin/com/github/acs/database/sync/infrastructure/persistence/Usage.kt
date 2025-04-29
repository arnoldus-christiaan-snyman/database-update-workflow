package com.github.acs.database.sync.infrastructure.persistence

import jakarta.persistence.*
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class Usage(
    var reference: UUID?,
    val calculatedRate: BigDecimal,
    val quantity: Int,
    val calculatedTax: BigDecimal,
    val calculatedTotalTaxExcluded: BigDecimal,
    val calculatedTotalTaxIncluded: BigDecimal,
    val isPaid: Boolean = false,
    val paidOn: LocalDateTime? = null,
    val calculatedOn: Timestamp = Timestamp.valueOf(LocalDateTime.now()),

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    val account: Account,

) : BaseEntity() {

    @PrePersist
    fun onPersist() {
        if(null == this.reference) this.reference = UUID.randomUUID()
    }

}
