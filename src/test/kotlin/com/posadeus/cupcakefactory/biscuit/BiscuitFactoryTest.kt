package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.cupcake.Topping
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertTrue

class BiscuitFactoryTest {

  private val biscuitFactory = BiscuitFactory()

  @Test
  internal fun `create a Biscuit with name and price`() {

    val topping = emptyList<Topping>()
    val biscuit = biscuitFactory.createBiscuit(topping)

    assertTrue { biscuit.name() == "Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.00"), USD_CURRENCY) }
  }

  @Test
  internal fun `create a chocolate topped biscuit`() {

    val topping = listOf(Topping.CHOCOLATE)
    val biscuit = biscuitFactory.createBiscuit(topping)

    assertTrue { biscuit.name() == "Chocolate Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.10"), USD_CURRENCY) }
  }

  companion object {

    private val USD_CURRENCY = Currency.getInstance("USD")
  }
}