package com.posadeus.cupcakefactory

import java.math.BigDecimal

class ChocolateCupcake : Cupcake {

  override fun name(): String =
      "Chocolate Cupcake"

  override fun price(): BigDecimal =
      BigDecimal("1.1")
}