package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Product
import java.math.BigDecimal

class Checkout {

  fun price(products: List<Product>): Price =
      if (products.isEmpty())
        Price(BigDecimal("0.00"))
      else
        Price(products
                  .map { it.price.value }
                  .reduce { acc, singleProductPrice -> acc.plus(singleProductPrice) })
}
