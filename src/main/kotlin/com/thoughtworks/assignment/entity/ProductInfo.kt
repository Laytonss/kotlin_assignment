package com.thoughtworks.assignment.entity

import com.google.gson.annotations.SerializedName

data class ProductInfo(
    val id: String,
    @SerializedName("SKU")
    val sku: String,
    val name: String,
    val price: Double,
    val type: String,
    val image: String
)