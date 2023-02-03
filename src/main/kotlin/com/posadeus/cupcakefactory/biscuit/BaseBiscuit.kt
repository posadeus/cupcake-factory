package com.posadeus.cupcakefactory.biscuit

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.product.Biscuit
import java.math.BigDecimal

class BaseBiscuit : Biscuit {

  override fun name(): String =
      "Biscuit"

  override fun price(): Price =
      Price(BigDecimal("2.00"))
}
