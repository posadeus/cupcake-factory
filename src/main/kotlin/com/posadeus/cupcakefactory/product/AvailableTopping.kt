package com.posadeus.cupcakefactory.product

import com.posadeus.cupcakefactory.common.exception.ToppingNotAllowedException
import com.posadeus.cupcakefactory.product.AvailableProducts.BISCUIT
import com.posadeus.cupcakefactory.product.AvailableProducts.CUPCAKE
import java.math.BigDecimal

enum class AvailableTopping(private val toppingName: String,
                            private val price: BigDecimal,
                            private val applicableOn: List<AvailableProducts>) {

  CHOCOLATE("Chocolate", BigDecimal("0.10"), listOf(CUPCAKE, BISCUIT)),
  NUTS("Nuts", BigDecimal("0.20"), listOf(CUPCAKE, BISCUIT)),
  VANILLA("Vanilla", BigDecimal("0.25"), listOf(CUPCAKE)),
  WHIPPED_CREAM("Whipped Cream", BigDecimal("0.30"), listOf(CUPCAKE));

  fun applyOn(productType: AvailableProducts, product: Product): Product =
      if (canApplyOn(productType))
        applyTopping(product)
      else
        throw ToppingNotAllowedException

  private fun canApplyOn(product: AvailableProducts): Boolean =
      this.applicableOn.contains(product)

  private fun applyTopping(product: Product): Product =
      ToppedProduct(product, this.toppingName, this.price)
}
