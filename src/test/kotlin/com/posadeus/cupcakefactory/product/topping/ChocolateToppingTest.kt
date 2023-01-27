package com.posadeus.cupcakefactory.product.topping

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Product
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class ChocolateToppingTest {

  private val product: Product = mockk()

  private val chocolateTopping = ChocolateTopping(product)

  @Test
  internal fun `name starts with Chocolate`() {

    every { product.name() } returns A_PRODUCT_NAME

    assertTrue { chocolateTopping.name() == "Chocolate $A_PRODUCT_NAME" }
  }

  @Test
  internal fun `chocolate price is 0,10 USD`() {

    val price = Price(BigDecimal("1.00"), Currency.getInstance("USD"))

    every { product.price() } returns price

    assertTrue { chocolateTopping.price() == Price(BigDecimal("1.10"), Currency.getInstance("USD")) }
  }

  companion object {

    private const val A_PRODUCT_NAME = "A_PRODUCT_NAME"
  }
}