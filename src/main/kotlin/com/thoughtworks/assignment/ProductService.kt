package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductDisplayInfo
import com.thoughtworks.assignment.entity.ProductInventory
import com.thoughtworks.assignment.entity.ProductInfo
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
            )
        }
    }

    private fun getQuantity(
        productInfo: ProductInfo,
        productInventorySkuMap: Map<String, List<ProductInventory>>
    ): Int {
        val productInventoryList = productInventorySkuMap.getOrElse(productInfo.sku) {
            throw RuntimeException("找不到库存信息")
        }
        return productInventoryList.sumOf { it.quantity }
    }
}
