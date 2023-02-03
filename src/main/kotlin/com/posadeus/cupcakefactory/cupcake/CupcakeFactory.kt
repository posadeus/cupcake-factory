package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.product.*

class CupcakeFactory {

  fun createCupcake(productType: AvailableProducts, availableTopping: List<AvailableTopping>): Cupcake {

    fun go(availableTopping: List<AvailableTopping>): Cupcake =
        if (availableTopping.isEmpty())
          BaseCupcake()
        else
          availableTopping.first().applyOn(productType, go(availableTopping.drop(1)))

    return go(availableTopping.asReversed())
  }
}
