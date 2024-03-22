package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.Product
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProductService {
    suspend fun getProductList(): List<Product> {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        val response = apiService.getProducts()
        return response
    }
}
