package com.posadeus.cupcakefactory.cupcake

import java.math.BigDecimal

class BaseCupcake : Cupcake {

  override fun name(): String =
      "Cupcake"

  override fun price(): BigDecimal =
      BigDecimal("1.00")
}