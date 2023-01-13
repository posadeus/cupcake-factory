package com.posadeus.cupcakefactory

import com.posadeus.cupcakefactory.Topping.CHOCOLATE
import com.posadeus.cupcakefactory.Topping.NUTS

class CupcakeFactory {

  fun createCupcake(topping: List<Topping>): Cupcake {

    fun go(topping: List<Topping>): Cupcake =
        if (topping.isEmpty())
          BaseCupcake()
        else
          when (topping.first()) {
            CHOCOLATE -> ChocolateCupcake(go(topping.drop(1)))
            NUTS -> NutsCupcake(go(topping.drop(1)))
          }

    return go(topping.asReversed())
  }
}
