package com.thoughtworks.assignment.entity

data class Inventory(
    val id: String,
    val sku: String,
    val zone: String,
    val quantity: Int,
)