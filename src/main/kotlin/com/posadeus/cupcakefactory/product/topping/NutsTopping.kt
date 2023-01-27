package com.posadeus.cupcakefactory.product.topping

import com.posadeus.cupcakefactory.product.Product
import com.posadeus.cupcakefactory.product.Topping
import java.math.BigDecimal

class NutsTopping(override val product: Product) : Topping(product) {

  override fun getName(): String =
      "Nuts"

  override fun getPrice(): BigDecimal =
      BigDecimal("0.20")
}