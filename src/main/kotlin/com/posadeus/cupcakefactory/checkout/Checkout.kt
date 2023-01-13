package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.BaseCupcake
import java.math.BigDecimal

class Checkout {

  fun price(cupcakes: List<BaseCupcake>): BigDecimal =
      if (cupcakes.isEmpty())
        BigDecimal.ZERO
      else
        BigDecimal.ONE
}
