package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.product.AvailableTopping
import com.posadeus.cupcakefactory.product.AvailableTopping.*
import com.posadeus.cupcakefactory.product.Cupcake
import com.posadeus.cupcakefactory.product.topping.ChocolateTopping
import com.posadeus.cupcakefactory.product.topping.NutsTopping

class CupcakeFactory {

  fun createCupcake(availableTopping: List<AvailableTopping>): Cupcake {

    fun go(availableTopping: List<AvailableTopping>): Cupcake =
        if (availableTopping.isEmpty())
          BaseCupcake()
        else
          when (availableTopping.first()) {
            CHOCOLATE -> ChocolateTopping(go(availableTopping.drop(1)))
            NUTS -> NutsTopping(go(availableTopping.drop(1)))
            VANILLA -> VanillaCupcake(go(availableTopping.drop(1)))
            WHIPPED_CREAM -> WhippedCreamCupcake(go(availableTopping.drop(1)))
          }

    return go(availableTopping.asReversed())
  }
}
