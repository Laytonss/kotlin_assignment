package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductDisplayInfo
import com.thoughtworks.assignment.entity.ProductType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProductDisplayInfoTest {
    @Test
    fun `should return right price when product type is NORMAL`() {
        val productDisplayInfo = ProductDisplayInfo("sku", "name", 5.0, 10, "image.jpg", ProductType.NORMAL)
        assertEquals(5.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity bigger than 100`() {
        val productDisplayInfo = ProductDisplayInfo("sku", "name", 10.0, 101, "image.jpg", ProductType.HIGH_DEMAND)
        assertEquals(10.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is 100`() {
        val productDisplayInfo = ProductDisplayInfo("sku", "name", 10.0, 100, "image.jpg", ProductType.HIGH_DEMAND)
        assertEquals(12.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is less than 100 and more than 30`() {
        val productDisplayInfo = ProductDisplayInfo("sku", "name", 10.0, 50, "image.jpg", ProductType.HIGH_DEMAND)
        assertEquals(12.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is 30`() {
        val productDisplayInfo = ProductDisplayInfo("sku", "name", 10.0, 30, "image.jpg", ProductType.HIGH_DEMAND)
        assertEquals(15.0, productDisplayInfo.getRealPrice())
    }

    @Test
    fun `should return right price when product type is HIGH_DEMAND and quantity is less than 30`() {
        val productDisplayInfo = ProductDisplayInfo("sku", "name", 10.0, 29, "image.jpg", ProductType.HIGH_DEMAND)
        assertEquals(15.0, productDisplayInfo.getRealPrice())
    }
}