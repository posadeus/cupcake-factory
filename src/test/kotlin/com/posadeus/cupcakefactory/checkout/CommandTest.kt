package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.*
import com.posadeus.cupcakefactory.product.AvailableProducts.BISCUIT
import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertTrue

class CommandTest {

  private val productFactory: ProductFactory = mockk()

  private val command = Command(productFactory)

  @Test
  internal fun `command a cupcake`() {

    val order = Order(CUPCAKE, listOf(A_TOPPING))
    val orders = listOf(order)

    every { productFactory.createProduct(CUPCAKE, listOf(A_TOPPING)) } returns A_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE) }
  }

  @Test
  internal fun `command a complex cupcake`() {

    val order = Order(CUPCAKE, listOf(A_TOPPING, ANOTHER_TOPPING))
    val orders = listOf(order)

    every { productFactory.createProduct(CUPCAKE, listOf(A_TOPPING, ANOTHER_TOPPING)) } returns A_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE) }
  }

  @Test
  internal fun `command multiple cupcakes`() {

    val order1 = Order(CUPCAKE, listOf(A_TOPPING, ANOTHER_TOPPING))
    val order2 = Order(CUPCAKE, emptyList())
    val orders = listOf(order1, order2)

    every { productFactory.createProduct(CUPCAKE, listOf(A_TOPPING, ANOTHER_TOPPING)) } returns A_CUPCAKE
    every { productFactory.createProduct(CUPCAKE, emptyList()) } returns ANOTHER_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE, ANOTHER_CUPCAKE) }
  }

  @Test
  internal fun `command a biscuit`() {

    val order = Order(BISCUIT, listOf(A_TOPPING))
    val orders = listOf(order)

    every { productFactory.createProduct(BISCUIT, listOf(A_TOPPING)) } returns A_BISCUIT

    assertTrue { command.order(orders) == listOf(A_BISCUIT) }
  }

  @Test
  internal fun `command a biscuit and a cupcake`() {

    val order1 = Order(BISCUIT, listOf(A_TOPPING))
    val order2 = Order(CUPCAKE, listOf(A_TOPPING))
    val orders = listOf(order1, order2)

    every { productFactory.createProduct(BISCUIT, listOf(A_TOPPING)) } returns A_BISCUIT
    every { productFactory.createProduct(CUPCAKE, listOf(A_TOPPING)) } returns A_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_BISCUIT, A_CUPCAKE) }
  }

  companion object {

    private val A_TOPPING = AvailableTopping.CHOCOLATE
    private val ANOTHER_TOPPING = AvailableTopping.NUTS
    private val A_CUPCAKE = Product("Cupcake", Price(BigDecimal("1.00")), emptySet())
    private val A_BISCUIT = Product("Biscuit", Price(BigDecimal("2.00")), emptySet())
    private val ANOTHER_CUPCAKE = Product("Cupcake", Price(BigDecimal("1.00")), emptySet())
  }
}