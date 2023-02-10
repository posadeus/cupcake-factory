package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.Price

class ProductFactory {

  fun createProduct(productType: AvailableProducts,
                    availableTopping: List<AvailableTopping>): Product {

    tailrec fun go(availableTopping: List<AvailableTopping>, product: Product): Product =
        if (availableTopping.isEmpty())
          product
        else
          go(availableTopping.drop(1),
             product.applyTopping(availableTopping.first(),
                                  name(product.name),
                                  price(product.price)))

    return go(availableTopping, productType.setBaseProduct())
  }

  private fun name(productName: String): (AvailableTopping) -> String =
      { a: AvailableTopping -> "${a.toppingName} $productName" }

  private fun price(productPrice: Price): (AvailableTopping) -> Price =
      { a: AvailableTopping -> Price(a.price.plus(productPrice.value),
                                     productPrice.currency) }
}
