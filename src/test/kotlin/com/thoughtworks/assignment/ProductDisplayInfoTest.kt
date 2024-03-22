package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductDisplayInfo
import com.thoughtworks.assignment.entity.ProductType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProductDisplayInfoTest {
    @Test
    fun `should return right price when product type is normal`() {
        val productDisplayInfo = ProductDisplayInfo("sku", "name", 5.0, 10, "image.jpg", ProductType.NORMAL)
        assertEquals(5.0, productDisplayInfo.getRealPrice())
    }
}