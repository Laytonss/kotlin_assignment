package com.thoughtworks.assignment

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class ProductServiceTest {
    @Test
    fun `should show product list when get products from products api`() {
        val productService = ProductService()
        runBlocking {
            val productInfoList = productService.getProductInfoList()
            assertEquals(5, productInfoList.size)
        }
    }

    @Test
    fun `should show inventory list when get inventory from inventory api`() {
        val productService = ProductService()
        runBlocking {
            val productInventoryList = productService.getProductInventoryList()
            assertEquals(8, productInventoryList.size)
        }
    }
}