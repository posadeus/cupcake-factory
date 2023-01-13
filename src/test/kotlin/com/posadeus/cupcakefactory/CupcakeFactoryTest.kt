package com.posadeus.cupcakefactory

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertTrue

class CupcakeFactoryTest {

  private val cupcakeFactory = CupcakeFactory()

  @Test
  internal fun `create a cupcake with name and price`() {

    val cupcake = cupcakeFactory.createCupcake(Topping.EMPTY)

    assertTrue { cupcake.name() == "Cupcake" }
    assertTrue { cupcake.price() == BigDecimal.ONE }
  }

  @Test
  internal fun `create a chocolate topping cupcake`() {

    val cupcake = cupcakeFactory.createCupcake(Topping.CHOCOLATE)

    assertTrue { cupcake.name() == "Chocolate Cupcake" }
    assertTrue { cupcake.price() == BigDecimal("1.1") }
  }
}