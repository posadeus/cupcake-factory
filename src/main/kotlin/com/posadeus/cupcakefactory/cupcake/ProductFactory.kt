package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.product.*

class ProductFactory {

  fun createProduct(productType: AvailableProducts,
                    availableTopping: List<AvailableTopping>): Product {

    fun go(availableTopping: List<AvailableTopping>): Product =
        if (availableTopping.isEmpty())
          productType.setBaseProduct()
        else
          availableTopping.first().applyOn(productType, go(availableTopping.drop(1)))

    return go(availableTopping.asReversed())
  }
}
