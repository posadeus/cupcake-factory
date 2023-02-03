package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.biscuit.BaseBiscuit
import com.posadeus.cupcakefactory.product.*
import com.posadeus.cupcakefactory.product.AvailableProducts.BISCUIT
import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE

class ProductFactory {

  fun createProduct(productType: AvailableProducts,
                    availableTopping: List<AvailableTopping>): Product {

    fun go(availableTopping: List<AvailableTopping>): Product =
        if (availableTopping.isEmpty())
          when (productType) {
            CUPCAKE -> BaseCupcake()
            BISCUIT -> BaseBiscuit()
          }
        else
          availableTopping.first().applyOn(productType, go(availableTopping.drop(1)))

    return go(availableTopping.asReversed())
  }
}
