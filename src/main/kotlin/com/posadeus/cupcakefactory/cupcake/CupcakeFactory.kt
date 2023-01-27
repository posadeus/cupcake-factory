package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.product.AvailableTopping
import com.posadeus.cupcakefactory.product.AvailableTopping.*
import com.posadeus.cupcakefactory.product.Cupcake

class CupcakeFactory {

  fun createCupcake(availableTopping: List<AvailableTopping>): Cupcake {

    fun go(availableTopping: List<AvailableTopping>): Cupcake =
        if (availableTopping.isEmpty())
          BaseCupcake()
        else
          when (availableTopping.first()) {
            CHOCOLATE -> ChocolateCupcake(go(availableTopping.drop(1)))
            NUTS -> NutsCupcake(go(availableTopping.drop(1)))
            VANILLA -> VanillaCupcake(go(availableTopping.drop(1)))
            WHIPPED_CREAM -> WhippedCreamCupcake(go(availableTopping.drop(1)))
          }

    return go(availableTopping.asReversed())
  }
}
