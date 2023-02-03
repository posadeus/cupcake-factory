package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.biscuit.BaseBiscuit
import com.posadeus.cupcakefactory.biscuit.BiscuitFactory
import com.posadeus.cupcakefactory.cupcake.BaseCupcake
import com.posadeus.cupcakefactory.cupcake.CupcakeFactory
import com.posadeus.cupcakefactory.product.AvailableProducts.BISCUIT
import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE
import com.posadeus.cupcakefactory.product.AvailableTopping
import com.posadeus.cupcakefactory.product.topping.ChocolateTopping
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class CommandTest {

  private val cupcakeFactory: CupcakeFactory = mockk()
  private val biscuitFactory: BiscuitFactory = mockk()

  private val command = Command(cupcakeFactory, biscuitFactory)

  @Test
  internal fun `command a cupcake`() {

    val order = Order(CUPCAKE, listOf(A_TOPPING))
    val orders = listOf(order)

    every { cupcakeFactory.createCupcake(CUPCAKE, listOf(A_TOPPING)) } returns A_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE) }
  }

  @Test
  internal fun `command a complex cupcake`() {

    val order = Order(CUPCAKE, listOf(A_TOPPING, ANOTHER_TOPPING))
    val orders = listOf(order)

    every { cupcakeFactory.createCupcake(CUPCAKE, listOf(A_TOPPING, ANOTHER_TOPPING)) } returns A_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE) }
  }

  @Test
  internal fun `command multiple cupcakes`() {

    val order1 = Order(CUPCAKE, listOf(A_TOPPING, ANOTHER_TOPPING))
    val order2 = Order(CUPCAKE, emptyList())
    val orders = listOf(order1, order2)

    every { cupcakeFactory.createCupcake(CUPCAKE, listOf(A_TOPPING, ANOTHER_TOPPING)) } returns A_CUPCAKE
    every { cupcakeFactory.createCupcake(CUPCAKE, emptyList()) } returns ANOTHER_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_CUPCAKE, ANOTHER_CUPCAKE) }
  }

  @Test
  internal fun `command a biscuit`() {

    val order = Order(BISCUIT, listOf(A_TOPPING))
    val orders = listOf(order)

    every { biscuitFactory.createBiscuit(listOf(A_TOPPING)) } returns A_BISCUIT

    assertTrue { command.order(orders) == listOf(A_BISCUIT) }
  }

  @Test
  internal fun `command a biscuit and a cupcake`() {

    val order1 = Order(BISCUIT, listOf(A_TOPPING))
    val order2 = Order(CUPCAKE, listOf(A_TOPPING))
    val orders = listOf(order1, order2)

    every { biscuitFactory.createBiscuit(listOf(A_TOPPING)) } returns A_BISCUIT
    every { cupcakeFactory.createCupcake(CUPCAKE, listOf(A_TOPPING)) } returns A_CUPCAKE

    assertTrue { command.order(orders) == listOf(A_BISCUIT, A_CUPCAKE) }
  }

  companion object {

    private val A_TOPPING = AvailableTopping.CHOCOLATE
    private val ANOTHER_TOPPING = AvailableTopping.NUTS
    private val A_CUPCAKE = ChocolateTopping(BaseCupcake())
    private val A_BISCUIT = ChocolateTopping(BaseBiscuit())
    private val ANOTHER_CUPCAKE = BaseCupcake()
  }
}