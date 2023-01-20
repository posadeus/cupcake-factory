package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.common.Price
import java.math.BigDecimal
import java.util.*

class NutsBiscuit(private val biscuit: Biscuit) : Biscuit {

  override fun name(): String =
      "Nuts ${biscuit.name()}"

  override fun price(): Price =
      Price(BigDecimal("0.20").plus(biscuit.price().value),
            Currency.getInstance("USD"))
}