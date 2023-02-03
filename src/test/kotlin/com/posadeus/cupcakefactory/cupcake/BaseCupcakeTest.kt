package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class BaseCupcakeTest {

  private val cupcake = BaseCupcake()

  @Test
  internal fun `name is Cupcake`() {

    assertTrue { cupcake.name() == "Cupcake" }
  }

  @Test
  internal fun `price is 1,00 USD`() {

    assertTrue { cupcake.price() == Price(BigDecimal("1.00")) }
  }
}