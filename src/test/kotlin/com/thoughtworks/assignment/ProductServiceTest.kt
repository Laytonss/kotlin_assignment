package com.thoughtworks.assignment

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class ProductServiceTest {
    @Test
    fun `should show product list when get products from products api`() {
        val productService = ProductService()
        runBlocking {
            val productList = productService.getProductList()
            assertEquals(5, productList.size)
        }
    }
}