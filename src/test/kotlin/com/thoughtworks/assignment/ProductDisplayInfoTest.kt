package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductDisplayInfo
import com.thoughtworks.assignment.entity.ProductType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProductDisplayInfoTest {
    private val initialPrice = 10.0

    @Test
    fun `should return right price when product type is NORMAL`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.NORMAL, 120, initialPrice)
        assertEquals(initialPrice, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity bigger than 100`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 101, initialPrice)
        assertEquals(initialPrice, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is 100`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 100, initialPrice)
        assertEquals(initialPrice * 1.2, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is less than 100 and more than 30`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 50, initialPrice)
        assertEquals(initialPrice * 1.2, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is 30`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 30, initialPrice)
        assertEquals(initialPrice * 1.5, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is less than 30`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 29, initialPrice)
        assertEquals(initialPrice * 1.5, productDisplayInfo.getRealPrice())
    }

    private fun buildProductDisplayInfoWithDefaultValue(
        type: ProductType,
        quantity: Int,
        initialPrice: Double,
        sku: String = "SKU",
        image: String = "image",
        name: String = "name"
    ): ProductDisplayInfo {
        return ProductDisplayInfo(sku, name, initialPrice, quantity, image, type)
    }
}