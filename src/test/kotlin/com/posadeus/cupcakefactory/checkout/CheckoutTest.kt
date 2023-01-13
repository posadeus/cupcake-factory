package com.posadeus.cupcakefactory.checkout

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertTrue

class CheckoutTest {

  private val checkout = Checkout()

  @Test
  internal fun `the price of an empty cart is ZERO`() {

    assertTrue { checkout.price() == BigDecimal.ZERO }
  }
}