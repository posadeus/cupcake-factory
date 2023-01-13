package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.*

class Order(private val cupcakeFactory: CupcakeFactory) {

  fun order(topping: List<Topping>): Cupcake =
      cupcakeFactory.createCupcake(topping)
}
