package com.posadeus.cupcakefactory.product.topping

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Product
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*

internal class NutsToppingTest {

  private val product: Product = mockk()

  private val nutsTopping = NutsTopping(product)

  @Test
  internal fun `name starts with Nuts`() {

    every { product.name() } returns A_PRODUCT_NAME

    assertTrue { nutsTopping.name() == "Nuts $A_PRODUCT_NAME" }
  }

  @Test
  internal fun `nuts price is 0,20 USD`() {

    val price = Price(BigDecimal("1.00"), Currency.getInstance("USD"))

    every { product.price() } returns price

    assertTrue { nutsTopping.price() == Price(BigDecimal("1.20"), Currency.getInstance("USD")) }
  }

  companion object {

    private const val A_PRODUCT_NAME = "A_PRODUCT_NAME"
  }
}