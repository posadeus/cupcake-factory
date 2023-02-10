package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.common.exception.ToppingNotAllowedException

data class Product(val name: String,
                   val price: Price,
                   val applicableTopping: Set<AvailableTopping>)

fun Product.applyTopping(topping: AvailableTopping,
                         f: (AvailableTopping) -> String,
                         g: (AvailableTopping) -> Price): Product =
    if (applicableTopping.contains(topping))
      Product(f(topping), g(topping), applicableTopping)
    else
      throw ToppingNotAllowedException