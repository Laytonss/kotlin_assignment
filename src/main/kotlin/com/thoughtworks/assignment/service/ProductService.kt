package com.thoughtworks.assignment.service

import com.thoughtworks.assignment.entity.ProductDisplayInfo
import com.thoughtworks.assignment.entity.ProductInventory
import com.thoughtworks.assignment.entity.ProductInfo
import com.thoughtworks.assignment.entity.ProductType
import com.thoughtworks.assignment.message.ErrorMessages
import com.thoughtworks.assignment.retrofit.ProductApiService
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


class ProductService(
    private val productApiService: ProductApiService
) {
    fun generateProductDisplayList(): List<ProductDisplayInfo> {
        return runBlocking {
            val productInfoResult = async { productApiService.getProductInfoList() }
            val productInventoryResult = async { productApiService.getProductInventoryList() }
            convertToDisplayList(productInfoResult.await(), productInventoryResult.await())
        }
    }

    private fun convertToDisplayList(
        productInfoList: List<ProductInfo>,
        productInventoryList: List<ProductInventory>
    ): List<ProductDisplayInfo> {
        val productInventorySkuMap = productInventoryList.groupBy { it.sku }
        return productInfoList.map {
            ProductDisplayInfo(
                sku = it.sku,
                name = it.name,
                initialPrice = it.price,
                quantity = getQuantity(it, productInventorySkuMap),
                image = it.image,
                type = ProductType.valueOf(it.type)
            )
        }
    }

    private fun getQuantity(
        productInfo: ProductInfo,
        productInventorySkuMap: Map<String, List<ProductInventory>>
    ): Int {
        val productInventoryList = productInventorySkuMap.getOrElse(productInfo.sku) {
            throw RuntimeException(ErrorMessages.NO_INVENTORY_FOUND)
        }
        return productInventoryList.sumOf { it.quantity }
    }
}
