package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.*
import com.posadeus.cupcakefactory.product.Topping
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class CommandTest {

  private val cupcakeFactory: CupcakeFactory = mockk()

  private val command = Command(cupcakeFactory)

  @Test
  internal fun `command a cupcake`() {

    val order = Order(listOf(A_TOPPING))
    val orders = listOf(order)

    every { cupcakeFactory.createCupcake(listOf(A_TOPPING)) } returns A_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE) }
  }

  @Test
  internal fun `command a complex cupcake`() {

    val order = Order(listOf(A_TOPPING, ANOTHER_TOPPING))
    val orders = listOf(order)

    every { cupcakeFactory.createCupcake(listOf(A_TOPPING, ANOTHER_TOPPING)) } returns A_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE) }
  }

  @Test
  internal fun `command multiple cupcakes`() {

    val order1 = Order(listOf(A_TOPPING, ANOTHER_TOPPING))
    val order2 = Order(emptyList())
    val orders = listOf(order1, order2)

    every { cupcakeFactory.createCupcake(listOf(A_TOPPING, ANOTHER_TOPPING)) } returns A_CUPCAKE
    every { cupcakeFactory.createCupcake(emptyList()) } returns ANOTHER_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE, ANOTHER_CUPCAKE) }
  }

  companion object {

    private val A_TOPPING = Topping.CHOCOLATE
    private val ANOTHER_TOPPING = Topping.NUTS
    private val A_CUPCAKE = ChocolateCupcake(BaseCupcake())
    private val ANOTHER_CUPCAKE = BaseCupcake()
  }
}