package com.thoughtworks.assignment

import com.thoughtworks.assignment.retrofit.RetrofitManager
import com.thoughtworks.assignment.service.ProductService

fun main() {
    val productDisplayList = ProductService(RetrofitManager.productApiService).generateProductDisplayList()
    println(String.format("%-35s%-35s%-35s%-35s%-35s", "SKU", "name", "price", "quantity", "image"))
    for (it in productDisplayList) {
        println(String.format("%-35s%-35s%-35s%-35s%-35s", it.sku, it.name, it.getRealPrice(), it.quantity, it.image))
    }
}