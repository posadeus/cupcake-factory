package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.product.Biscuit
import com.posadeus.cupcakefactory.product.Topping

class BiscuitFactory {

  fun createBiscuit(topping: List<Topping>): Biscuit {

    fun go(topping: List<Topping>): Biscuit =
        if (topping.isEmpty())
          BaseBiscuit()
        else
          if (topping.first() == Topping.CHOCOLATE)
            ChocolateBiscuit(go(topping.drop(1)))
          else if (topping.first() == Topping.NUTS)
            NutsBiscuit(go(topping.drop(1)))
          else
            BaseBiscuit()

    return go(topping.asReversed())
  }
}
