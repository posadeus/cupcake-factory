package com.posadeus.cupcakefactory.it

import com.posadeus.cupcakefactory.checkout.*
import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.common.exception.ToppingNotAllowedException
import com.posadeus.cupcakefactory.product.AvailableProducts.*
import com.posadeus.cupcakefactory.product.AvailableTopping.*
import com.posadeus.cupcakefactory.product.ProductFactory
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import kotlin.test.assertTrue

class CheckoutFacadeIT {

  private val checkout = CheckoutFacade(Command(ProductFactory()),
                                        Checkout())

  @Test
  fun `checkout empty cart`() {

    assertTrue { checkout.order(emptyList()) == Price(BigDecimal("0.00")) }
  }

  @Test
  fun `checkout a simple cupcake`() {

    val order = Order(CUPCAKE, emptyList())

    assertTrue { checkout.order(listOf(order)) == Price(BigDecimal("1.00")) }
  }

  @Test
  fun `checkout a topped cupcake`() {

    val order = Order(CUPCAKE, listOf(VANILLA))

    assertTrue { checkout.order(listOf(order)) == Price(BigDecimal("1.25")) }
  }

  @Test
  fun `checkout a multiple topped cupcake`() {

    val order = Order(CUPCAKE, listOf(WHIPPED_CREAM, CHOCOLATE))

    assertTrue { checkout.order(listOf(order)) == Price(BigDecimal("1.40")) }
  }

  @Test
  fun `checkout a multiple cupcakes`() {

    val order1 = Order(CUPCAKE, listOf(WHIPPED_CREAM, CHOCOLATE))
    val order2 = Order(CUPCAKE, emptyList())

    assertTrue { checkout.order(listOf(order1, order2)) == Price(BigDecimal("2.40")) }
  }

  @Test
  fun `checkout a multiple products`() {

    val order1 = Order(CUPCAKE, listOf(WHIPPED_CREAM, CHOCOLATE))
    val order2 = Order(CUPCAKE, emptyList())
    val order3 = Order(BISCUIT, listOf(CHOCOLATE))

    assertTrue { checkout.order(listOf(order1, order2, order3)) == Price(BigDecimal("4.50")) }
  }

  @Test
  fun `checkout fails due to a not allowed topping`() {

    val order = Order(BISCUIT, listOf(VANILLA))

    assertThrows<ToppingNotAllowedException> { checkout.order(listOf(order)) }
  }

  @Test
  fun `checkout a bundled cupcake`() {

    val order = Order(BUNDLE_1_CUPCAKE, emptyList())

    assertTrue { checkout.order(listOf(order)) == Price(BigDecimal("1.17")) }
  }

  @Test
  fun `checkout a bundled cupcake and biscuit`() {

    val order = Order(BUNDLE_1_CUPCAKE_1_BISCUIT, emptyList())

    assertTrue { checkout.order(listOf(order)) == Price(BigDecimal("2.70")) }
  }

  @Test
  fun `checkout two bundled cupcake and biscuit`() {

    val order = Order(BUNDLE_2_CUPCAKE_1_BISCUIT, emptyList())

    assertTrue { checkout.order(listOf(order)) == Price(BigDecimal("3.92")) }
  }
}