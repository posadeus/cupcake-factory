package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class VanillaCupcakeTest {

  private val cupcake: Cupcake = mockk()

  private val vanillaCupcake = VanillaCupcake(cupcake)

  @Test
  internal fun `name starts with Vanilla`() {

    every { cupcake.name() } returns "Cupcake"

    assertTrue { vanillaCupcake.name() == "Vanilla Cupcake" }
  }

  @Test
  internal fun `vanilla price is 0,25 USD`() {

    val price = Price(BigDecimal("1.00"), Currency.getInstance("USD"))

    every { cupcake.price() } returns price

    assertTrue { vanillaCupcake.price() == Price(BigDecimal("1.25"), Currency.getInstance("USD")) }
  }
}