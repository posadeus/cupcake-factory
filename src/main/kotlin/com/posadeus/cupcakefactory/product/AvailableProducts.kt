package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import java.math.BigDecimal

enum class AvailableProducts(private val baseProduct: Product) {

  CUPCAKE(Product("Cupcake", Price(BigDecimal("1.00")))),
  BISCUIT(Product("Biscuit", Price(BigDecimal("2.00"))));

  fun setBaseProduct(): Product =
      this.baseProduct
}