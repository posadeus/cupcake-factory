package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.BaseCupcake
import com.posadeus.cupcakefactory.cupcake.ChocolateCupcake
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

  @Test
  internal fun `the price of a topped cupcake depend from topping`() {

    assertTrue { checkout.price(listOf(ChocolateCupcake(BaseCupcake()))) == BigDecimal("1.1") }
  }

  @Test
  internal fun `checkout multiple cupcakes`() {

    assertTrue { checkout.price(listOf(BaseCupcake(), ChocolateCupcake(BaseCupcake()))) == BigDecimal("2.1") }
  }
}