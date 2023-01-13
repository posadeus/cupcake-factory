package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class NutsCupcakeTest {

  private val cupcake: Cupcake = mockk()

  private val nutsCupcake = NutsCupcake(cupcake)

  @Test
  internal fun `name starts with Nuts`() {

    every { cupcake.name() } returns "Cupcake"

    assertTrue { nutsCupcake.name() == "Nuts Cupcake" }
  }

  @Test
  internal fun `nuts price is 0,20 USD`() {

    val price = Price(BigDecimal("1.00"), Currency.getInstance("USD"))

    every { cupcake.price() } returns price

    assertTrue { nutsCupcake.price() == Price(BigDecimal("1.20"), Currency.getInstance("USD")) }
  }
}