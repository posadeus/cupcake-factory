package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.common.Price

class CheckoutFacade(private val command: Command,
                     private val checkout: Checkout) {

  fun order(orders: List<Order>): Price =
      checkout.price(command.order(orders))
}
