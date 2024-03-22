package com.thoughtworks.assignment.entity

data class ProductDisplayInfo(
    val sku: String,
    val name: String,
    val initialPrice: Double,
    val quantity: Int,
    val image: String
)