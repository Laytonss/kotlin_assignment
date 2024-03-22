package com.thoughtworks.assignment.retrofit

import com.thoughtworks.assignment.entity.ProductInventory
import com.thoughtworks.assignment.entity.ProductInfo
import retrofit2.http.GET

interface ProductApiService {
    @GET("/products")
    suspend fun getProductInfoList(): List<ProductInfo>

    @GET("/inventories")
    suspend fun getProductInventoryList(): List<ProductInventory>
}