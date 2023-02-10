package com.posadeus.cupcakefactory.common

import java.math.BigDecimal
import java.util.*

data class Price(val value: BigDecimal,
                 val currency: Currency = Currency.getInstance("USD"))

fun Price.applyDiscount(discount: Discount): Price =
    Price(value.multiply(BigDecimal(100 - discount.percentage)).divide(BigDecimal("100.00")).stripTrailingZeros().setScale(2),
          currency)
