package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductDisplayInfo
import com.thoughtworks.assignment.entity.ProductType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProductDisplayInfoTest {
    @Test
    fun `should return right price when product type is NORMAL`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.NORMAL, 120, 5.0)
        assertEquals(5.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity bigger than 100`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 101, 10.0)
        assertEquals(10.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is 100`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 100, 10.0)
        assertEquals(12.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is less than 100 and more than 30`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 50, 10.0)
        assertEquals(12.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is 30`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 30, 10.0)
        assertEquals(15.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is less than 30`() {
        val productDisplayInfo = buildProductDisplayInfoWithDefaultValue(ProductType.HIGH_DEMAND, 29, 10.0)
        assertEquals(15.0, productDisplayInfo.getRealPrice())
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