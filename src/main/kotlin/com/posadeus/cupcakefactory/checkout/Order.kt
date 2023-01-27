package com.posadeus.cupcakefactory.checkout

import com.posadeus.cupcakefactory.product.AvailableProducts
import com.posadeus.cupcakefactory.product.AvailableTopping

data class Order(val baseProduct: AvailableProducts,
                 val availableToppings: List<AvailableTopping>)
