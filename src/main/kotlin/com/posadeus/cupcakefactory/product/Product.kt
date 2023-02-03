package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import java.math.BigDecimal

sealed interface Product {

  fun name(): String

  fun price(): Price
}

object Cupcake : Product {

  override fun name(): String =
      "Cupcake"

  override fun price(): Price =
      Price(BigDecimal("1.00"))
}

object Biscuit : Product {

  override fun name(): String =
      "Biscuit"

  override fun price(): Price =
      Price(BigDecimal("2.00"))
}