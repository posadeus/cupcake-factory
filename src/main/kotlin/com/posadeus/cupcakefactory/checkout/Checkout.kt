package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.Cupcake
import java.math.BigDecimal

class Checkout {

  fun price(cupcakes: List<Cupcake>): BigDecimal =
      if (cupcakes.isEmpty())
        BigDecimal("0.00")
      else
        cupcakes.map { it.price() }
            .reduce { acc, singleCupcakePrice -> acc.plus(singleCupcakePrice) }
}
