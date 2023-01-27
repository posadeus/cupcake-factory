package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.product.AvailableTopping

data class Order(val availableToppings: List<AvailableTopping>)
