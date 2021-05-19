package com.playground.currency_template

data class Currencies(val date: String,
                      val success: Boolean,
                      val rates: Rates,
                      val timestamp: Int,
                      val base: String)