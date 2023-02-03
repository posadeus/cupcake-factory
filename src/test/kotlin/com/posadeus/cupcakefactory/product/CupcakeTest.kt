package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Cupcake
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class CupcakeTest {

  private val cupcake = Cupcake

  @Test
  internal fun `name is Cupcake`() {

    assertTrue { cupcake.name() == "Cupcake" }
  }

  @Test
  internal fun `price is 1,00 USD`() {

    assertTrue { cupcake.price() == Price(BigDecimal("1.00")) }
  }
}