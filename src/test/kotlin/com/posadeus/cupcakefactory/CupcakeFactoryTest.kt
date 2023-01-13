package com.posadeus.cupcakefactory

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class CupcakeFactoryTest {

  private val cupcakeFactory = CupcakeFactory()

  @Test
  internal fun `create a cupcake`() {

    assertTrue { cupcakeFactory.createCupcake() == Cupcake }
  }
}