package com.posadeus.cupcakefactory.product.topping

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Product
import com.posadeus.cupcakefactory.product.Topping
import java.math.BigDecimal
import java.util.*

class NutsTopping(private val product: Product) : Topping() {

  override fun name(): String =
      "Nuts ${product.name()}"

  override fun price(): Price =
      Price(BigDecimal("0.20").plus(product.price().value),
            Currency.getInstance("USD"))
}