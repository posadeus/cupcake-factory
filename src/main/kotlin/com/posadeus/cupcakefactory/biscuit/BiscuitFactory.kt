package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.product.AvailableTopping
import com.posadeus.cupcakefactory.product.Biscuit
import com.posadeus.cupcakefactory.product.topping.ChocolateTopping
import com.posadeus.cupcakefactory.product.topping.NutsTopping

class BiscuitFactory {

  fun createBiscuit(availableTopping: List<AvailableTopping>): Biscuit {

    fun go(availableTopping: List<AvailableTopping>): Biscuit =
        if (availableTopping.isEmpty())
          BaseBiscuit()
        else
          if (availableTopping.first() == AvailableTopping.CHOCOLATE)
            ChocolateTopping(go(availableTopping.drop(1)))
          else if (availableTopping.first() == AvailableTopping.NUTS)
            NutsTopping(go(availableTopping.drop(1)))
          else
            BaseBiscuit()

    return go(availableTopping.asReversed())
  }
}
