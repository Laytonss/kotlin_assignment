package com.thoughtworks.assignment.entity

data class Product(
    val id: Int,
    val sku: String,
    val name: String,
    val price: Double,
    val type: String,
    val image: String,
)