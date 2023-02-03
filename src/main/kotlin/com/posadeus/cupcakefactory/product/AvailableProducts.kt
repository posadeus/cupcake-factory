package com.posadeus.cupcakefactory.product

enum class AvailableProducts(private val baseProduct: Product) {

  CUPCAKE(Cupcake),
  BISCUIT(Biscuit);

  fun setBaseProduct(): Product =
      this.baseProduct
}