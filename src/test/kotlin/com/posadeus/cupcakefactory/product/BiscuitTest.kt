package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class BiscuitTest {

  private val biscuit = Biscuit

  @Test
  internal fun `name is Cupcake`() {

    assertTrue { biscuit.name() == "Biscuit" }
  }

  @Test
  internal fun `price is 2,00 USD`() {

    assertTrue { biscuit.price() == Price(BigDecimal("2.00")) }
  }
}