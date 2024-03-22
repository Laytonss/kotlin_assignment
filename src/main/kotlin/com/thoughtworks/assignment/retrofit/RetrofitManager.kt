package com.thoughtworks.assignment.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitManager {

    private val retrofit: Retrofit

    init {
        val properties = Properties()
        val inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties")
        properties.load(inputStream)
        val baseUrl = properties.getProperty("base_url")

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val productApiService: ProductApiService = retrofit.create(ProductApiService::class.java)
}