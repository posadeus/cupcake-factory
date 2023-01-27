package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Cupcake
import com.posadeus.cupcakefactory.product.CupcakeTopping
import java.math.BigDecimal
import java.util.*

class WhippedCreamCupcake(private val cupcake: Cupcake) : CupcakeTopping() {

  override fun name(): String =
      "WhippedCream ${cupcake.name()}"

  override fun price(): Price =
      Price(BigDecimal("0.30").plus(cupcake.price().value),
            Currency.getInstance("USD"))
}