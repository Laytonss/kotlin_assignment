package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.ProductInventory
import com.thoughtworks.assignment.entity.ProductInfo


class ProductService {

    suspend fun getProductInfoList(): List<ProductInfo> {
        return RetrofitManager.productApiService.getProductInfoList()
    }

    suspend fun getProductInventoryList(): List<ProductInventory> {
        return RetrofitManager.productApiService.getProductInventoryList()
    }
}
