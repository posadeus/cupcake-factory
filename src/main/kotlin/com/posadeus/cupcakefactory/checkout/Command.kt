package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.biscuit.BiscuitFactory
import com.posadeus.cupcakefactory.cupcake.CupcakeFactory
import com.posadeus.cupcakefactory.product.AvailableProducts.BISCUIT
import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE
import com.posadeus.cupcakefactory.product.Product

class Command(private val cupcakeFactory: CupcakeFactory,
              private val biscuitFactory: BiscuitFactory) {

  fun order(orders: List<Order>): List<Product> =
      orders.map {
        when (it.baseProduct) {
          CUPCAKE -> cupcakeFactory.createCupcake(it.availableToppings)
          BISCUIT -> biscuitFactory.createBiscuit(it.availableToppings)
        }
      }
}
