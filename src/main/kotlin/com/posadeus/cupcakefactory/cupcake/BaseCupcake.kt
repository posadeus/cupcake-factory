package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Cupcake
import java.math.BigDecimal

class BaseCupcake : Cupcake {

  override fun name(): String =
      "Cupcake"

  override fun price(): Price =
      Price(BigDecimal("1.00"))
}