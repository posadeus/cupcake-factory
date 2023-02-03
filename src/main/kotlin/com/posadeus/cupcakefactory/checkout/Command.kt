package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.ProductFactory
import com.posadeus.cupcakefactory.product.Product

class Command(private val productFactory: ProductFactory) {

  fun order(orders: List<Order>): List<Product> =
      orders.map { productFactory.createProduct(it.baseProduct, it.availableToppings) }
}
