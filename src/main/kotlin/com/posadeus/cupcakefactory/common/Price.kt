package com.posadeus.cupcakefactory.common

import java.math.BigDecimal
import java.util.*

data class Price(val value: BigDecimal,
                 val currency: Currency = Currency.getInstance("USD"))
