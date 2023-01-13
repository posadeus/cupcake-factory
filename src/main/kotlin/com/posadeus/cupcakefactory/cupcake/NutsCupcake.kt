package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import java.math.BigDecimal
import java.util.*

class NutsCupcake(private val cupcake: Cupcake) : Cupcake {

  override fun name(): String =
      "Nuts ${cupcake.name()}"

  override fun price(): Price =
      Price(BigDecimal("0.20").plus(cupcake.price().value),
            Currency.getInstance("USD"))
}