package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Discount
import com.posadeus.cupcakefactory.common.Price
import com.posadeus.cupcakefactory.common.exception.ToppingNotAllowedException

data class Product(val name: String,
                   val price: Price,
                   val applicableTopping: Set<AvailableTopping>,
                   val discount: Discount? = null)

fun Product.applyTopping(topping: AvailableTopping,
                         rename: (AvailableTopping) -> String,
                         reprice: (AvailableTopping) -> Price): Product =
    if (applicableTopping.contains(topping))
      Product(rename(topping), reprice(topping), applicableTopping, discount)
    else
      throw ToppingNotAllowedException