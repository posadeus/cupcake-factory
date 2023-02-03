package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.biscuit.BaseBiscuit
import com.posadeus.cupcakefactory.cupcake.BaseCupcake

enum class AvailableProducts(private val baseProduct: Product) {

  CUPCAKE(BaseCupcake()),
  BISCUIT(BaseBiscuit());

  fun setBaseProduct(): Product =
      this.baseProduct
}