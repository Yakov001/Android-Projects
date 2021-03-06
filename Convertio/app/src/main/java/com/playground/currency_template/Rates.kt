package com.playground.currency_template

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
data class Rates(
    val AUD: Double,
    val AWG: Double,
    val AZN: Double,
    val BAM: Double,
    val BBD: Double,
    val BDT: Double,
    val BGN: Double,
    val BHD: Double,
    val BIF: Double,
    val BMD: Double,
    val BND: Double,
    val BOB: Double,
    val BRL: Double,
    val BSD: Double,
    val BTC: Double,
    val BTN: Double,
    val BWP: Double,
    val BYN: Double,
    val BYR: Double,
    val BZD: Double,
    val CAD: Double,
    val CDF: Double,
    val CHF: Double,
    val CLF: Double,
    val CLP: Double,
    val CNY: Double,
    val COP: Double,
    val CRC: Double,
    val CUC: Double,
    val CUP: Double,
    val CVE: Double,
    val CZK: Double,
    val DJF: Double,
    @PrimaryKey
    val EUR: Int,
    val FJD: Double,
    val FKP: Double,
    val GBP: Double,
    val GEL: Double,
    val GGP: Double,
    val GHS: Double,
    val GIP: Double,
    val GMD: Double,
    val GNF: Double,
    val GTQ: Double,
    val GYD: Double,
    val HKD: Double,
    val HNL: Double,
    val HRK: Double,
    val HTG: Double,
    val HUF: Double,
    val JEP: Double,
    val JMD: Double,
    val JOD: Double,
    val JPY: Double,
    val PEN: Double,
    val PGK: Double,
    val PHP: Double,
    val PKR: Double,
    val PLN: Double,
    val PYG: Double,
    val QAR: Double,
    val RON: Double,
    val RSD: Double,
    val RUB: Double,
    val USD: Double,
)