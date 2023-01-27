package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Product
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class ChocolateCupcakeTest {

  private val product: Product = mockk()

  private val chocolateCupcake = ChocolateCupcake(product)

  @Test
  internal fun `name starts with Chocolate`() {

    every { product.name() } returns "Cupcake"

    assertTrue { chocolateCupcake.name() == "Chocolate Cupcake" }
  }

  @Test
  internal fun `chocolate price is 0,10 USD`() {

    val price = Price(BigDecimal("1.00"), Currency.getInstance("USD"))

    every { product.price() } returns price

    assertTrue { chocolateCupcake.price() == Price(BigDecimal("1.10"), Currency.getInstance("USD")) }
  }
}