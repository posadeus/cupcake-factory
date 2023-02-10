package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Product
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
  internal fun `checkout single product`() {

    val product = aProductWith(Price(BigDecimal("1.00")))
    val expected = Price(BigDecimal("1.00"))

    assertTrue { checkout.price(listOf(product)) == expected }
  }

  @Test
  internal fun `checkout multiple products`() {

    val firstProduct = aProductWith(Price(BigDecimal("1.00")))
    val secondProduct = aProductWith(Price(BigDecimal("2.30")))
    val expected = Price(BigDecimal("3.30"))

    assertTrue { checkout.price(listOf(firstProduct, secondProduct)) == expected }
  }

  private fun aProductWith(price: Price) =
      Product("A_PRODUCT_NAME", price)
}