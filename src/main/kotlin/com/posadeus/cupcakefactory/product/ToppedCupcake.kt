package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import java.math.BigDecimal

class ToppedCupcake(private val cupcake: Cupcake,
                    private val toppingName: String,
                    private val price: BigDecimal) : Cupcake {

  override fun name(): String =
      "$toppingName ${cupcake.name()}"

  override fun price(): Price =
      Price(price.plus(cupcake.price().value),
            cupcake.price().currency)
}
