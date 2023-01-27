package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.cupcake.BaseCupcake
import com.posadeus.cupcakefactory.cupcake.ChocolateTopping
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertTrue

class CheckoutTest {

  private val checkout = Checkout()

  @Test
  internal fun `the price of an empty cart is ZERO`() {

    val price = Price(BigDecimal("0.00"), Currency.getInstance("USD"))

    assertTrue { checkout.price(emptyList()) == price }
  }

  @Test
  internal fun `the price of a base cupcake is ONE`() {

    val price = Price(BigDecimal("1.00"), Currency.getInstance("USD"))

    assertTrue { checkout.price(listOf(BaseCupcake())) == price }
  }

  @Test
  internal fun `the price of a topped cupcake depend from topping`() {

    val price = Price(BigDecimal("1.10"), Currency.getInstance("USD"))

    assertTrue { checkout.price(listOf(ChocolateTopping(BaseCupcake()))) == price }
  }

  @Test
  internal fun `checkout multiple cupcakes`() {

    val price = Price(BigDecimal("2.10"), Currency.getInstance("USD"))

    assertTrue { checkout.price(listOf(BaseCupcake(), ChocolateTopping(BaseCupcake()))) == price }
  }
}