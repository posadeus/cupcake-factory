package com.posadeus.cupcakefactory.cupcake

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.common.exception.ToppingNotAllowedException
import com.posadeus.cupcakefactory.product.AvailableProducts.BISCUIT
import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE
import com.posadeus.cupcakefactory.product.AvailableTopping
import com.posadeus.cupcakefactory.product.AvailableTopping.CHOCOLATE
import com.posadeus.cupcakefactory.product.AvailableTopping.NUTS
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import kotlin.test.assertTrue

class ProductFactoryTest {

  private val productFactory = ProductFactory()

  @Test
  internal fun `create a cupcake with name and price`() {

    val availableTopping = emptyList<AvailableTopping>()
    val cupcake = productFactory.createProduct(CUPCAKE, availableTopping)

    assertTrue { cupcake.name() == "Cupcake" }
    assertTrue { cupcake.price() == Price(BigDecimal("1.00")) }
  }

  @Test
  internal fun `create a chocolate topped cupcake`() {

    val topping = listOf(CHOCOLATE)
    val cupcake = productFactory.createProduct(CUPCAKE, topping)

    assertTrue { cupcake.name() == "Chocolate Cupcake" }
    assertTrue { cupcake.price() == Price(BigDecimal("1.10")) }
  }

  @Test
  internal fun `create a chocolate and nuts topped cupcake`() {

    val topping = listOf(CHOCOLATE, NUTS)
    val cupcake = productFactory.createProduct(CUPCAKE, topping)

    assertTrue { cupcake.name() == "Nuts Chocolate Cupcake" }
    assertTrue { cupcake.price() == Price(BigDecimal("1.30")) }
  }

  @Test
  internal fun `create a nuts and chocolate topped cupcake`() {

    val topping = listOf(NUTS, CHOCOLATE)
    val cupcake = productFactory.createProduct(CUPCAKE, topping)

    assertTrue { cupcake.name() == "Chocolate Nuts Cupcake" }
    assertTrue { cupcake.price() == Price(BigDecimal("1.30")) }
  }

  @Test
  internal fun `create a Biscuit with name and price`() {

    val availableTopping = emptyList<AvailableTopping>()
    val biscuit = productFactory.createProduct(BISCUIT, availableTopping)

    assertTrue { biscuit.name() == "Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.00")) }
  }

  @Test
  internal fun `create a chocolate topped biscuit`() {

    val availableTopping = listOf(CHOCOLATE)
    val biscuit = productFactory.createProduct(BISCUIT, availableTopping)

    assertTrue { biscuit.name() == "Chocolate Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.10")) }
  }

  @Test
  internal fun `create a chocolate and nuts topped biscuit`() {

    val availableToppings = listOf(CHOCOLATE, NUTS)
    val biscuit = productFactory.createProduct(BISCUIT, availableToppings)

    assertTrue { biscuit.name() == "Nuts Chocolate Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.30")) }
  }

  @Test
  internal fun `create a nuts topped biscuit`() {

    val availableTopping = listOf(NUTS)
    val biscuit = productFactory.createProduct(BISCUIT, availableTopping)

    assertTrue { biscuit.name() == "Nuts Biscuit" }
    assertTrue { biscuit.price() == Price(BigDecimal("2.20")) }
  }

  @Test
  internal fun `topping not for biscuits cannot be applied`() {

    val availableTopping = listOf(AvailableTopping.VANILLA)

    assertThrows<ToppingNotAllowedException> { productFactory.createProduct(BISCUIT, availableTopping) }
  }
}