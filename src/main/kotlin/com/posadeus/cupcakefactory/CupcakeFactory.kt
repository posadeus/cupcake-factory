package com.posadeus.cupcakefactory

import java.math.BigDecimal

class CupcakeFactory {

  fun createCupcake(): Cupcake =
      Cupcake("A_NAME", BigDecimal.ONE)
}
