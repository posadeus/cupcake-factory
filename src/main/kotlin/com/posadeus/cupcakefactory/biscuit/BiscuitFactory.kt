package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.common.exception.ToppingNotAllowedException
import com.posadeus.cupcakefactory.product.AvailableTopping
import com.posadeus.cupcakefactory.product.AvailableTopping.CHOCOLATE
import com.posadeus.cupcakefactory.product.AvailableTopping.NUTS
import com.posadeus.cupcakefactory.product.Biscuit
import com.posadeus.cupcakefactory.product.topping.ChocolateTopping
import com.posadeus.cupcakefactory.product.topping.NutsTopping

class BiscuitFactory {

  fun createBiscuit(availableTopping: List<AvailableTopping>): Biscuit {

    fun go(availableTopping: List<AvailableTopping>): Biscuit =
        if (availableTopping.isEmpty())
          BaseBiscuit()
        else
          when (availableTopping.first()) {
            CHOCOLATE -> ChocolateTopping(go(availableTopping.drop(1)))
            NUTS -> NutsTopping(go(availableTopping.drop(1)))
            else -> throw ToppingNotAllowedException
          }

    return go(availableTopping.asReversed())
  }
}
