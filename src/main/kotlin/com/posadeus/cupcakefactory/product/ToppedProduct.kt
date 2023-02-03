package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import java.math.BigDecimal

class ToppedProduct(private val product: Product,
                    private val toppingName: String,
                    private val price: BigDecimal) : Product {

  override fun name(): String =
      "$toppingName ${product.name()}"

  override fun price(): Price =
      Price(price.plus(product.price().value),
            product.price().currency)
}
