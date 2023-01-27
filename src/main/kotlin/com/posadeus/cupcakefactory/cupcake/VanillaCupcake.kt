package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.product.Cupcake
import com.posadeus.cupcakefactory.product.CupcakeTopping
import java.math.BigDecimal

class VanillaCupcake(override val cupcake: Cupcake) : CupcakeTopping(cupcake) {

  override fun getName(): String =
      "Vanilla"

  override fun getPrice(): BigDecimal =
      BigDecimal("0.25")
}