package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.Inventory
import com.thoughtworks.assignment.entity.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProductService {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)

    suspend fun getProductList(): List<Product> {
        return apiService.getProducts()
    }

    suspend fun getInventoryList(): List<Inventory> {
        return apiService.getInventories()
    }
}
