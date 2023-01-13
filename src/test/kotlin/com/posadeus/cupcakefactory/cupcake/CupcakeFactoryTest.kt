package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.cupcake.Topping.CHOCOLATE
import com.posadeus.cupcakefactory.cupcake.Topping.NUTS
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
    assertTrue { cupcake.price() == BigDecimal("1.00") }
  }

  @Test
  internal fun `create a chocolate topped cupcake`() {

    val topping = listOf(CHOCOLATE)
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Chocolate Cupcake" }
    assertTrue { cupcake.price() == BigDecimal("1.10") }
  }

  @Test
  internal fun `create a chocolate and nuts topped cupcake`() {

    val topping = listOf(CHOCOLATE, NUTS)
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Nuts Chocolate Cupcake" }
    assertTrue { cupcake.price() == BigDecimal("1.30") }
  }

  @Test
  internal fun `create a nuts and chocolate topped cupcake`() {

    val topping = listOf(NUTS, CHOCOLATE)
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Chocolate Nuts Cupcake" }
    assertTrue { cupcake.price() == BigDecimal("1.30") }
  }
}