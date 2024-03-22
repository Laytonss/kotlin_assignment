package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductInfo
import com.thoughtworks.assignment.entity.ProductInventory
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RetrofitManagerTest {

    private val productApiService = RetrofitManager.productApiService

    @Test
    fun `should get right product info list`() {
        runBlocking {
            val productInfoList = productApiService.getProductInfoList()
            assertEquals(5, productInfoList.size)
            assertEquals(
                ProductInfo("1", "ABC123", "Electronic Watch", 299.99, "NORMAL", "image1.jpg"),
                productInfoList[0]
            )
        }
    }

    @Test
    fun `should get right product inventory list`() {
        runBlocking {
            val productInventoryList = productApiService.getProductInventoryList()
            assertEquals(8, productInventoryList.size)
            assertEquals(
                ProductInventory("1", "ABC123", "CN_NORTH", 120),
                productInventoryList[0]
            )
        }
    }
}