package com.thoughtworks.assignment

import com.thoughtworks.assignment.entity.Inventory
import com.thoughtworks.assignment.entity.Product


class ProductService {

    suspend fun getProductList(): List<Product> {
        return RetrofitManager.apiService.getProducts()
    }

    suspend fun getInventoryList(): List<Inventory> {
        return RetrofitManager.apiService.getInventories()
    }
}
