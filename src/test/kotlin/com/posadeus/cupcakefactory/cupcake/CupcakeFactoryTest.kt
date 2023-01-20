package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Topping
import com.posadeus.cupcakefactory.product.Topping.CHOCOLATE
import com.posadeus.cupcakefactory.product.Topping.NUTS
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertTrue

class CupcakeFactoryTest {

  private val cupcakeFactory = CupcakeFactory()

  @Test
  internal fun `create a cupcake with name and price`() {

    val topping = emptyList<Topping>()
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Cupcake" }
    assertTrue { cupcake.price() == Price(BigDecimal("1.00"), USD_CURRENCY) }
  }

  @Test
  internal fun `create a chocolate topped cupcake`() {

    val topping = listOf(CHOCOLATE)
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Chocolate Cupcake" }
    assertTrue { cupcake.price() == Price(BigDecimal("1.10"), USD_CURRENCY) }
  }

  @Test
  internal fun `create a chocolate and nuts topped cupcake`() {

    val topping = listOf(CHOCOLATE, NUTS)
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Nuts Chocolate Cupcake" }
    assertTrue { cupcake.price() == Price(BigDecimal("1.30"), USD_CURRENCY) }
  }

  @Test
  internal fun `create a nuts and chocolate topped cupcake`() {

    val topping = listOf(NUTS, CHOCOLATE)
    val cupcake = cupcakeFactory.createCupcake(topping)

    assertTrue { cupcake.name() == "Chocolate Nuts Cupcake" }
    assertTrue { cupcake.price() == Price(BigDecimal("1.30"), USD_CURRENCY) }
  }

  companion object {

    private val USD_CURRENCY = Currency.getInstance("USD")
  }
}