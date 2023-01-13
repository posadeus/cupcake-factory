package com.posadeus.cupcakefactory.cupcake

import java.math.BigDecimal

class NutsCupcake(private val cupcake: Cupcake) : Cupcake {

  override fun name(): String =
      "Nuts ${cupcake.name()}"

  override fun price(): BigDecimal =
      BigDecimal("0.2").plus(cupcake.price())
}