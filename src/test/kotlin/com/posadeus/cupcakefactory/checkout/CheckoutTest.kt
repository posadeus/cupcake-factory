package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.biscuit.BaseBiscuit
import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.cupcake.BaseCupcake
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
  internal fun `checkout multiple cupcakes`() {

    val price = Price(BigDecimal("2.00"), Currency.getInstance("USD"))

    assertTrue { checkout.price(listOf(BaseCupcake(), BaseCupcake())) == price }
  }

  @Test
  internal fun `the price of a base biscuit is TWO`() {

    val price = Price(BigDecimal("2.00"), Currency.getInstance("USD"))

    assertTrue { checkout.price(listOf(BaseBiscuit())) == price }
  }
}