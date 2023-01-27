package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.AvailableTopping
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.util.*
import kotlin.test.assertTrue

class BiscuitFactoryTest {

  private val biscuitFactory = BiscuitFactory()

  @Test
  internal fun `create a Biscuit with name and price`() {

    val availableTopping = emptyList<AvailableTopping>()
    val biscuit = biscuitFactory.createBiscuit(availableTopping)

    assertTrue { biscuit.name() == "Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.00"), USD_CURRENCY) }
  }

  @Test
  internal fun `create a chocolate topped biscuit`() {

    val availableTopping = listOf(AvailableTopping.CHOCOLATE)
    val biscuit = biscuitFactory.createBiscuit(availableTopping)

    assertTrue { biscuit.name() == "Chocolate Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.10"), USD_CURRENCY) }
  }

  @Test
  internal fun `create a chocolate and nuts topped biscuit`() {

    val availableToppings = listOf(AvailableTopping.CHOCOLATE, AvailableTopping.NUTS)
    val biscuit = biscuitFactory.createBiscuit(availableToppings)

    assertTrue { biscuit.name() == "Nuts Chocolate Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.30"), USD_CURRENCY) }
  }

  @Test
  internal fun `create a nuts topped biscuit`() {

    val availableTopping = listOf(AvailableTopping.NUTS)
    val biscuit = biscuitFactory.createBiscuit(availableTopping)

    assertTrue { biscuit.name() == "Nuts Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.20"), USD_CURRENCY) }
  }

  companion object {

    private val USD_CURRENCY = Currency.getInstance("USD")
  }
}