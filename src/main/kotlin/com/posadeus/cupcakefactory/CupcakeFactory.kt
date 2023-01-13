package com.posadeus.cupcakefactory

class CupcakeFactory {

  fun createCupcake(topping: Topping): Cupcake =
      when (topping) {
        Topping.EMPTY -> BaseCupcake()
        Topping.CHOCOLATE -> ChocolateCupcake()
      }
}
