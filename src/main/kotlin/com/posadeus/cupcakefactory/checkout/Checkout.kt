package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.Cupcake
import java.math.BigDecimal

class Checkout {

  fun price(cupcakes: List<Cupcake>): BigDecimal =
      if (cupcakes.isEmpty())
        BigDecimal.ZERO
      else
        cupcakes.map { it.price() }
            .reduce { acc, singleCupcakePrice -> acc.plus(singleCupcakePrice) }
}
