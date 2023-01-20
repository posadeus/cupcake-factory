package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Biscuit
import java.math.BigDecimal
import java.util.*

class ChocolateBiscuit(private val biscuit: Biscuit) : Biscuit {

  override fun name(): String =
      "Chocolate ${biscuit.name()}"

  override fun price(): Price =
      Price(BigDecimal("0.10").plus(biscuit.price().value),
            Currency.getInstance("USD"))
}