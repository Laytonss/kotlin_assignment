package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductDisplayInfo
import com.thoughtworks.assignment.entity.ProductInfo
import com.thoughtworks.assignment.entity.ProductInventory
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals


class ProductServiceTest {

    @Test
    fun `should get product display info when hava one to one info`() {
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

    @Test
    fun `should get correct quantity when one product have two zone`() {
        // given
        val mockApiService = mockk<ProductApiService>()
        val mockProductInfoList = arrayListOf(ProductInfo("1", "ABC", "product1", 5.0, "NORMAL", "image3.jpg"))
        val mockProductInventoryList = arrayListOf(
            ProductInventory("1", "ABC", "china", 5),
            ProductInventory("2", "ABC", "England", 3)
        )
        coEvery { mockApiService.getProductInfoList() }.returns(mockProductInfoList)
        coEvery { mockApiService.getProductInventoryList() }.returns(mockProductInventoryList)
        // when
        val productService = ProductService(mockApiService)
        val productDisplayInfoList = productService.generateProductDisplayList()
        // then
        assertEquals(arrayListOf(ProductDisplayInfo("ABC", "product1", 5.0, 8, "image3.jpg")), productDisplayInfoList)
    }

    @Test
    fun `should get correct quantity when multiple products have multiple zone`() {
        // given
        val mockApiService = mockk<ProductApiService>()
        val mockProductInfoList = arrayListOf(
            ProductInfo("1", "ABC", "product1", 5.0, "NORMAL", "image3.jpg"),
            ProductInfo("2", "SKU2", "product2", 5.0, "NORMAL", "image4.jpg")
        )
        val mockProductInventoryList = arrayListOf(
            ProductInventory("1", "ABC", "china", 5),
            ProductInventory("2", "ABC", "England", 3),
            ProductInventory("3", "SKU2", "America", 5),
            ProductInventory("4", "SKU2", "India", 3)
        )
        coEvery { mockApiService.getProductInfoList() }.returns(mockProductInfoList)
        coEvery { mockApiService.getProductInventoryList() }.returns(mockProductInventoryList)
        // when
        val productService = ProductService(mockApiService)
        val productDisplayInfoList = productService.generateProductDisplayList()
        // then
        assertEquals(
            arrayListOf(
                ProductDisplayInfo("ABC", "product1", 5.0, 8, "image3.jpg"),
                ProductDisplayInfo("SKU2", "product2", 5.0, 8, "image4.jpg")
            ), productDisplayInfoList
        )
    }

    @Test
    fun `should throw Exception when one product sku can not find in product inventory`() {
        // given
        val mockApiService = mockk<ProductApiService>()
        val mockProductInfoList = arrayListOf(ProductInfo("1", "ABC", "product1", 5.0, "NORMAL", "image3.jpg"))
        val mockProductInventoryList = arrayListOf(ProductInventory("1", "AB", "china", 5))
        coEvery { mockApiService.getProductInfoList() }.returns(mockProductInfoList)
        coEvery { mockApiService.getProductInventoryList() }.returns(mockProductInventoryList)
        // when
        val productService = ProductService(mockApiService)
        // then
        assertThrows<RuntimeException> {
            productService.generateProductDisplayList()
        }
    }
}