package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price

class ToppedProduct(private val toppingName: String,
                    private val price: Price) : Product {

  override fun name(): String =
      toppingName

  override fun price(): Price =
      price
}
