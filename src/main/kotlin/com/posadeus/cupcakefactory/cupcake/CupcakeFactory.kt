package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.cupcake.Topping.*
import com.posadeus.cupcakefactory.product.Cupcake

class CupcakeFactory {

  fun createCupcake(topping: List<Topping>): Cupcake {

    fun go(topping: List<Topping>): Cupcake =
        if (topping.isEmpty())
          BaseCupcake()
        else
          when (topping.first()) {
            CHOCOLATE -> ChocolateCupcake(go(topping.drop(1)))
            NUTS -> NutsCupcake(go(topping.drop(1)))
            VANILLA -> VanillaCupcake(go(topping.drop(1)))
            WHIPPED_CREAM -> WhippedCreamCupcake(go(topping.drop(1)))
          }

    return go(topping.asReversed())
  }
}
