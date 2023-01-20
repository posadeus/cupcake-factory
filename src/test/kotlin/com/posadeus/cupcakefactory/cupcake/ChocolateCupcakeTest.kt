package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Cupcake
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class ChocolateCupcakeTest {

  private val cupcake: Cupcake = mockk()

  private val chocolateCupcake = ChocolateCupcake(cupcake)

  @Test
  internal fun `name starts with Chocolate`() {

    every { cupcake.name() } returns "Cupcake"

    assertTrue { chocolateCupcake.name() == "Chocolate Cupcake" }
  }

  @Test
  internal fun `chocolate price is 0,10 USD`() {

    val price = Price(BigDecimal("1.00"), Currency.getInstance("USD"))

    every { cupcake.price() } returns price

    assertTrue { chocolateCupcake.price() == Price(BigDecimal("1.10"), Currency.getInstance("USD")) }
  }
}