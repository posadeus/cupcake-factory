package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE
import com.posadeus.cupcakefactory.product.Product
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertTrue

class CheckoutFacadeTest {

  private val command: Command = mockk()
  private val checkout: Checkout = mockk()

  private val checkoutFacade = CheckoutFacade(command, checkout)

  @Test
  internal fun `get price of a command`() {

    val orders = listOf(AN_ORDER, ANOTHER_ORDER)
    val cupcakes = listOf(A_CUPCAKE, ANOTHER_CUPCAKE)

    every { command.order(orders) } returns cupcakes
    every { checkout.price(cupcakes) } returns A_PRICE

    assertTrue { checkoutFacade.order(orders) == A_PRICE }
  }

  companion object {

    private val AN_ORDER = Order(CUPCAKE, emptyList())
    private val ANOTHER_ORDER = Order(CUPCAKE, emptyList())
    private val A_PRICE = Price(BigDecimal.TEN)
    private val A_CUPCAKE = Product("A_NAME", A_PRICE, emptySet())
    private val ANOTHER_CUPCAKE = Product("A_NAME", A_PRICE, emptySet())
  }
}