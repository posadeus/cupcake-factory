package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.biscuit.BiscuitFactory
import com.posadeus.cupcakefactory.cupcake.ProductFactory
import com.posadeus.cupcakefactory.product.AvailableProducts.BISCUIT
import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE
import com.posadeus.cupcakefactory.product.Product

class Command(private val productFactory: ProductFactory,
              private val biscuitFactory: BiscuitFactory) {

  fun order(orders: List<Order>): List<Product> =
      orders.map {
        when (it.baseProduct) {
          CUPCAKE -> productFactory.createProduct(CUPCAKE, it.availableToppings)
          BISCUIT -> biscuitFactory.createBiscuit(it.availableToppings)
        }
      }
}
