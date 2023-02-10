package com.posadeus.cupcakefactory.product

import java.math.BigDecimal

enum class AvailableTopping(val toppingName: String,
                            val price: BigDecimal) {

  CHOCOLATE("Chocolate", BigDecimal("0.10")),
  NUTS("Nuts", BigDecimal("0.20")),
  VANILLA("Vanilla", BigDecimal("0.25")),
  WHIPPED_CREAM("Whipped Cream", BigDecimal("0.30"))
}
