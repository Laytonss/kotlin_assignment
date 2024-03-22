package com.thoughtworks.assignment.entity

data class ProductDisplayInfo(
    val sku: String,
    val name: String,
    val initialPrice: Double,
    val quantity: Int,
    val image: String,
    val type: ProductType
) {
    fun getRealPrice(): Double {
        return if (type == ProductType.NORMAL) initialPrice
        else if (100 < quantity) initialPrice
        else if (30 < quantity) initialPrice * 1.2
        else initialPrice * 1.5
    }
}