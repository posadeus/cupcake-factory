package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.product.Topping

data class Order(val toppings: List<Topping>)
