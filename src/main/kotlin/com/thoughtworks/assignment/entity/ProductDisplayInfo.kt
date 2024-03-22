package com.thoughtworks.assignment.entity

enum class ProductType {
    NORMAL, HIGH_DEMAND
}

data class ProductDisplayInfo(
    val sku: String,
    val name: String,
    val initialPrice: Double,
    val quantity: Int,
    val image: String,
    val type: ProductType
) {
    fun getRealPrice(): Double {
        return 0.0
    }
}