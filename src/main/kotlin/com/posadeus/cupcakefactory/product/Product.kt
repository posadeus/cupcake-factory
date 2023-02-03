package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price

sealed interface Product {

  fun name(): String

  fun price(): Price
}

interface Cupcake : Product
interface Biscuit : Product