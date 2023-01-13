package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import java.math.BigDecimal
import java.util.*

class WhippedCreamCupcake(private val cupcake: Cupcake) : Cupcake {

  override fun name(): String =
      "WhippedCream ${cupcake.name()}"

  override fun price(): Price =
      Price(BigDecimal("0.30").plus(cupcake.price().value),
            Currency.getInstance("USD"))
}