package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price

sealed interface Product {

  fun name(): String

  fun price(): Price
}

interface Cupcake : Product
interface Biscuit : Product

abstract class Topping : Cupcake, Biscuit {

  abstract override fun name(): String

  abstract override fun price(): Price
}

abstract class CupcakeTopping : Cupcake {

  abstract override fun name(): String

  abstract override fun price(): Price
}