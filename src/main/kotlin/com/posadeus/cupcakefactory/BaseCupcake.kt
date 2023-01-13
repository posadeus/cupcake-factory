package com.posadeus.cupcakefactory

import java.math.BigDecimal

class BaseCupcake : Cupcake {

  override fun name(): String =
      "Cupcake"

  override fun price(): BigDecimal =
      BigDecimal.ONE
}