package com.posadeus.cupcakefactory.product.topping

import com.posadeus.cupcakefactory.product.Product
import com.posadeus.cupcakefactory.product.Topping
import java.math.BigDecimal

class ChocolateTopping(override val product: Product) : Topping(product) {

  override fun getName(): String =
      "Chocolate"

  override fun getPrice(): BigDecimal =
      BigDecimal("0.10")
}