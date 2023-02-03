package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE
import com.posadeus.cupcakefactory.product.AvailableTopping
import com.posadeus.cupcakefactory.product.Cupcake

class CupcakeFactory {

  fun createCupcake(availableTopping: List<AvailableTopping>): Cupcake {

    fun go(availableTopping: List<AvailableTopping>): Cupcake =
        if (availableTopping.isEmpty())
          BaseCupcake()
        else
          availableTopping.first().applyOn(CUPCAKE, go(availableTopping.drop(1)))

    return go(availableTopping.asReversed())
  }
}
