package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.*

class Order(private val cupcakeFactory: CupcakeFactory) {

  fun order(topping: Topping): Cupcake =
      cupcakeFactory.createCupcake(listOf(topping))
}
