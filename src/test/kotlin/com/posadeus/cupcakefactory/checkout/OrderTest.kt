package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.cupcake.*
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class OrderTest {

  private val cupcakeFactory: CupcakeFactory = mockk()

  private val order = Order(cupcakeFactory)

  @Test
  internal fun `order a cupcake`() {

    every { cupcakeFactory.createCupcake(listOf(A_TOPPING)) } returns A_CUPCAKE

    assertTrue { order.order(listOf(A_TOPPING)) == A_CUPCAKE }
  }

  @Test
  internal fun `order a complex cupcake`() {

    every { cupcakeFactory.createCupcake(listOf(A_TOPPING, ANOTHER_TOPPING)) } returns A_CUPCAKE

    assertTrue { order.order(listOf(A_TOPPING, ANOTHER_TOPPING)) == A_CUPCAKE }
  }

  companion object {

    private val A_TOPPING = Topping.CHOCOLATE
    private val ANOTHER_TOPPING = Topping.NUTS
    private val A_CUPCAKE = ChocolateCupcake(BaseCupcake())
  }
}