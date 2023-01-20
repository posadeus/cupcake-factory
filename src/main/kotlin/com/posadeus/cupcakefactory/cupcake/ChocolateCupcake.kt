package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Cupcake
import java.math.BigDecimal
import java.util.*

class ChocolateCupcake(private val cupcake: Cupcake) : Cupcake {

  override fun name(): String =
      "Chocolate ${cupcake.name()}"

  override fun price(): Price =
      Price(BigDecimal("0.10").plus(cupcake.price().value),
            Currency.getInstance("USD"))
}