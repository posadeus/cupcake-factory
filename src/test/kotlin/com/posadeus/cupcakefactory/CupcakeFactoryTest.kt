package com.posadeus.cupcakefactory

import org.junit.jupiter.api.Test
import java.math.BigDecimal
import kotlin.test.assertTrue

class CupcakeFactoryTest {

  private val cupcakeFactory = CupcakeFactory()

  @Test
  internal fun `create a cupcake with name and price`() {

    assertTrue { cupcakeFactory.createCupcake() == Cupcake(A_NAME, A_PRICE) }
  }

  companion object {

    private const val A_NAME = "A_NAME"
    private val A_PRICE = BigDecimal.ONE
  }
}