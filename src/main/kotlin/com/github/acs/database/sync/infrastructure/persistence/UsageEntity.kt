package com.github.acs.database.sync.infrastructure.persistence

import jakarta.persistence.*
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.Positive
import org.hibernate.annotations.UuidGenerator
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "USAGE")
data class UsageEntity(
    @get:Id
    @get:UuidGenerator
    @get:Column(nullable = false, updatable = false, unique = true)
    var reference: UUID?,

    @get:NotBlank(message = "Usage needs to have a calculated rate")
    @get:Positive(message = "Calculated rate must be greater than 0")
    @get:Column(nullable = false)
    val calculatedRate: BigDecimal,

    @get:Positive(message = "Quantity must be greater than 0")
    @get:Column(nullable = false)
    val quantity: Int,

    @get:Min(value = 0, message = "Value can't be negative")
    @get:Column(nullable = false)
    val calculatedTax: BigDecimal,

    @get:Column(nullable = false)
    var calculatedTotalTaxExcluded: BigDecimal? = null,

    @get:Column(nullable = false)
    var calculatedTotalTaxIncluded: BigDecimal? = null,

    @get:Column(nullable = false)
    val isPaid: Boolean = false,

    var paidOn: Timestamp? = null,

    @get:PastOrPresent(message = "Invalid timestamp. Created on timestamp can only be in the past or present.")
    @get:Column(nullable = false, updatable = false)
    val calculatedOn: Timestamp? = Timestamp.valueOf(LocalDateTime.now()),

    @get:NotNull(message = "A usage needs to be assigned to an account")
    @get:ManyToOne
    @get:JoinColumn(name = "ACCOUNT_ID", nullable = false)
    @get:Column(nullable = false, updatable = false)
    val account: AccountEntity,

    ) : BaseEntity() {

    @PrePersist
    fun onPersist() {
        setPaidTimestamp()
        calculateTotalExcludingTax()
        calculateTotalIncludingTax()
    }

    private fun setPaidTimestamp() {
        if(this.isPaid && null == this.paidOn) {
            this.paidOn = Timestamp.valueOf(LocalDateTime.now())
        }

    }

    private fun calculateTotalExcludingTax() {
        if(null == this.calculatedTotalTaxExcluded) {
            this.calculatedTotalTaxExcluded = this.calculatedRate.multiply(BigDecimal(quantity))
        }
    }

    private fun calculateTotalIncludingTax() {
        if(null == this.calculatedTotalTaxIncluded) {
            this.calculatedTotalTaxIncluded = calculatedTotalTaxExcluded!!.add(this.calculatedTax)
        }
    }

}
