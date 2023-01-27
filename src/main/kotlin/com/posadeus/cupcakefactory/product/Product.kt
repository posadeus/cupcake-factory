package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import java.math.BigDecimal

sealed interface Product {

  fun name(): String

  fun price(): Price
}

interface Cupcake : Product
interface Biscuit : Product

abstract class Topping(open val product: Product) : Cupcake, Biscuit {

  override fun name(): String =
      "${getName()} ${product.name()}"

  override fun price(): Price =
      Price(getPrice().plus(product.price().value),
            product.price().currency)

  protected abstract fun getName(): String

  protected abstract fun getPrice(): BigDecimal
}

abstract class CupcakeTopping(open val cupcake: Cupcake) : Cupcake {

  override fun name(): String =
      "${getName()} ${cupcake.name()}"

  override fun price(): Price =
      Price(getPrice().plus(cupcake.price().value),
            cupcake.price().currency)

  protected abstract fun getName(): String

  protected abstract fun getPrice(): BigDecimal
}