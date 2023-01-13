package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.Cupcake
import com.posadeus.cupcakefactory.cupcake.CupcakeFactory

class Command(private val cupcakeFactory: CupcakeFactory) {

  fun order(orders: List<Order>): List<Cupcake> =
      orders.map { cupcakeFactory.createCupcake(it.toppings) }
}
