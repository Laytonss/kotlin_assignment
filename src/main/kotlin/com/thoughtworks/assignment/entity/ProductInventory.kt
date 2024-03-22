package com.thoughtworks.assignment.entity

import com.google.gson.annotations.SerializedName

data class ProductInventory(
    val id: String,
    @SerializedName("SKU")
    val sku: String,
    val zone: String,
    val quantity: Int,
)