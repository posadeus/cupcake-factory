package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Biscuit
import com.posadeus.cupcakefactory.product.Cupcake
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertTrue

class CheckoutTest {

  private val checkout = Checkout()

  @Test
  internal fun `the price of an empty cart is ZERO`() {

    val price = Price(BigDecimal("0.00"))

    assertTrue { checkout.price(emptyList()) == price }
  }

  @Test
  internal fun `the price of a base cupcake is ONE`() {

    val price = Price(BigDecimal("1.00"))

    assertTrue { checkout.price(listOf(Cupcake)) == price }
  }

  @Test
  internal fun `checkout multiple cupcakes`() {

    val price = Price(BigDecimal("2.00"))

    assertTrue { checkout.price(listOf(Cupcake, Cupcake)) == price }
  }

  @Test
  internal fun `the price of a base biscuit is TWO`() {

    val price = Price(BigDecimal("2.00"))

    assertTrue { checkout.price(listOf(Biscuit)) == price }
  }
}