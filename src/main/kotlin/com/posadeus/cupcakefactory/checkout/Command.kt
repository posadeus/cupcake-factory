package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.CupcakeFactory
import com.posadeus.cupcakefactory.product.Cupcake

class Command(private val cupcakeFactory: CupcakeFactory) {

  fun order(orders: List<Order>): List<Cupcake> =
      orders.map { cupcakeFactory.createCupcake(it.toppings) }
}
