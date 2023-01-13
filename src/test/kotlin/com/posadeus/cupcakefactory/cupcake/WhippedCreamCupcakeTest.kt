package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class WhippedCreamCupcakeTest {

  private val cupcake: Cupcake = mockk()

  private val whippedCreamCupcake = WhippedCreamCupcake(cupcake)

  @Test
  internal fun `name starts with WhippedCream`() {

    every { cupcake.name() } returns "Cupcake"

    assertTrue { whippedCreamCupcake.name() == "WhippedCream Cupcake" }
  }

  @Test
  internal fun `whippedCream price is 0,30 USD`() {

    val price = Price(BigDecimal("1.00"), Currency.getInstance("USD"))

    every { cupcake.price() } returns price

    assertTrue { whippedCreamCupcake.price() == Price(BigDecimal("1.30"), Currency.getInstance("USD")) }
  }
}