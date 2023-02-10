package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Discount
import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.AvailableTopping.*
import java.math.BigDecimal

enum class AvailableProducts(val baseProduct: Product) {

  CUPCAKE(Product("Cupcake", Price(BigDecimal("1.00")), setOf(CHOCOLATE, NUTS, VANILLA, WHIPPED_CREAM))),
  BISCUIT(Product("Biscuit", Price(BigDecimal("2.00")), setOf(CHOCOLATE, NUTS))),

  BUNDLE_1_CUPCAKE(Product("Whipped Cream Cupcake Bundle", Price(BigDecimal("1.30")), emptySet(), Discount(10))),
  BUNDLE_1_CUPCAKE_1_BISCUIT(Product("Cupcake and Biscuit Bundle", Price(BigDecimal("3.00")), emptySet(), Discount(10))),
  BUNDLE_2_CUPCAKE_1_BISCUIT(Product("Vanilla Cupcake, Chocolate Cupcake and Nuts Biscuit Bundle", Price(BigDecimal("4.35")), emptySet(), Discount(10)))
}