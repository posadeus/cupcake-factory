package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.AvailableTopping.*
import java.math.BigDecimal

enum class AvailableProducts(private val baseProduct: Product) {

  CUPCAKE(Product("Cupcake", Price(BigDecimal("1.00")), setOf(CHOCOLATE, NUTS, VANILLA, WHIPPED_CREAM))),
  BISCUIT(Product("Biscuit", Price(BigDecimal("2.00")), setOf(CHOCOLATE, NUTS)));

  fun setBaseProduct(): Product =
      this.baseProduct
}