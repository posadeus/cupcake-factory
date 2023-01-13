package com.posadeus.cupcakefactory.checkout

import java.math.BigDecimal

class CheckoutFacade(private val command: Command,
                     private val checkout: Checkout) {

  fun order(orders: List<Order>): BigDecimal =
      checkout.price(command.order(orders))
}
