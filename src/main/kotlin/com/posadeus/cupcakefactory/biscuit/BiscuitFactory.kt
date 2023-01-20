package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.cupcake.Topping

class BiscuitFactory {

  fun createBiscuit(topping: List<Topping>): Biscuit =
      if (topping.isEmpty())
        BaseBiscuit(topping)
      else
        ChocolateBiscuit(BaseBiscuit(topping))
}
