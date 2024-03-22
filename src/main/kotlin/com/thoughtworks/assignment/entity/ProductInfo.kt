package com.thoughtworks.assignment.entity

data class ProductInfo(
    val id: String,
    val sku: String,
    val name: String,
    val price: Double,
    val type: String,
    val image: String
)