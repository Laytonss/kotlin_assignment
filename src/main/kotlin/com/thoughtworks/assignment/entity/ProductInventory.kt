package com.thoughtworks.assignment.entity

data class ProductInventory(
    val id: String,
    val sku: String,
    val zone: String,
    val quantity: Int,
)