package com.posadeus.cupcakefactory.cupcake

import java.math.BigDecimal

class ChocolateCupcake(private val cupcake: Cupcake) : Cupcake {

  override fun name(): String =
      "Chocolate ${cupcake.name()}"

  override fun price(): BigDecimal =
      BigDecimal("0.10").plus(cupcake.price())
}