package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Cupcake
import java.math.BigDecimal
import java.util.*

class Checkout {

  fun price(cupcakes: List<Cupcake>): Price =
      if (cupcakes.isEmpty())
        Price(BigDecimal("0.00"), Currency.getInstance("USD"))
      else
        Price(cupcakes
                  .map { it.price().value }
                  .reduce { acc, singleCupcakePrice -> acc.plus(singleCupcakePrice) },
              Currency.getInstance("USD"))
}
