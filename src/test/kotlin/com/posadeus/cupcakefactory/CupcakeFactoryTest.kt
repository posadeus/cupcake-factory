package com.posadeus.cupcakefactory

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertTrue

class CupcakeFactoryTest {

  private val cupcakeFactory = CupcakeFactory()

  @Test
  internal fun `create a cupcake with name and price`() {

    val topping = emptyList<Topping>()
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Cupcake" }
    assertTrue { cupcake.price() == BigDecimal.ONE }
  }

  @Test
  internal fun `create a chocolate topped cupcake`() {

    val topping = listOf(Topping.CHOCOLATE)
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Chocolate Cupcake" }
    assertTrue { cupcake.price() == BigDecimal("1.1") }
  }

  @Test
  internal fun `create a chocolate and nuts topped cupcake`() {

    val topping = listOf(Topping.CHOCOLATE, Topping.NUTS)
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Nuts Chocolate Cupcake" }
    assertTrue { cupcake.price() == BigDecimal("1.3") }
  }
}