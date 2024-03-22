package com.thoughtworks.assignment

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:3000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val productApiService: ProductApiService = retrofit.create(ProductApiService::class.java)
}