package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.Inventory
import com.thoughtworks.assignment.entity.Product
import retrofit2.http.GET

interface ApiService {
    @GET("/products")
    suspend fun getProducts(): List<Product>

    @GET("/inventories")
    suspend fun getInventories(): List<Inventory>
}