package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductDisplayInfo
import com.thoughtworks.assignment.entity.ProductInfo
import com.thoughtworks.assignment.entity.ProductInventory
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class ProductServiceTest {

    @Test
    fun `should get product display info`() {
        // given
        val mockApiService = mockk<ProductApiService>()
        val mockProductInfoList = arrayListOf(ProductInfo("1", "ABC", "product1", 5.0, "NORMAL", "image3.jpg"))
        val mockProductInventoryList = arrayListOf(ProductInventory("1", "ABC", "china", 5))
        coEvery { mockApiService.getProductInfoList() }.returns(mockProductInfoList)
        coEvery { mockApiService.getProductInventoryList() }.returns(mockProductInventoryList)
        // when
        val productService = ProductService(mockApiService)
        val productDisplayInfoList = productService.generateProductDisplayList()
        // then
        assertEquals(arrayListOf(ProductDisplayInfo("ABC", "product1", 5.0, 5, "image3.jpg")), productDisplayInfoList)
    }
}