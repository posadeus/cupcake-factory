package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Cupcake
import java.math.BigDecimal
import java.util.*

class BaseCupcake : Cupcake {

  override fun name(): String =
      "Cupcake"

  override fun price(): Price =
      Price(BigDecimal("1.00"), Currency.getInstance("USD"))
}