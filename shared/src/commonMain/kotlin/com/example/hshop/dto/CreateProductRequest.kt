package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateProductRequest(
    val name: String,
    val description: String,
    val price: Double,
    val categoryId: String,
    val stockQuantity: Int,
    val imageUrls: List<String>,
    val sku: String
)