package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Discount
import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.AvailableTopping.*
import java.math.BigDecimal

enum class AvailableProducts(val baseProduct: Product) {

  CUPCAKE(Product("Cupcake", Price(BigDecimal("1.00")), setOf(CHOCOLATE, NUTS, VANILLA, WHIPPED_CREAM))),
  BISCUIT(Product("Biscuit", Price(BigDecimal("2.00")), setOf(CHOCOLATE, NUTS))),

  BUNDLE_1_CUPCAKE(Product("Whipped Cream Cupcake Bundle", Price(BigDecimal("1.30")), emptySet(), Discount(10)))
}