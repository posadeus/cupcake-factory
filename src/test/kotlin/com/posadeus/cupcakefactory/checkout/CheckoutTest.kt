package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.BaseCupcake
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertTrue

class CheckoutTest {

  private val checkout = Checkout()

  @Test
  internal fun `the price of an empty cart is ZERO`() {

    assertTrue { checkout.price(emptyList()) == BigDecimal.ZERO }
  }

  @Test
  internal fun `the price of a base cupcake is ONE`() {

    assertTrue { checkout.price(listOf(BaseCupcake())) == BigDecimal.ONE }
  }
}