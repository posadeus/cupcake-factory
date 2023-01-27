package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Cupcake
import com.posadeus.cupcakefactory.product.Product
import java.math.BigDecimal
import java.util.*

class ChocolateCupcake(private val product: Product) : Cupcake {

  override fun name(): String =
      "Chocolate ${product.name()}"

  override fun price(): Price =
      Price(BigDecimal("0.10").plus(product.price().value),
            Currency.getInstance("USD"))
}