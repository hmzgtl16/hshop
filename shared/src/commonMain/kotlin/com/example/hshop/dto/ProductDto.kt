package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val categoryId: String,
    val categoryName: String,
    val stockQuantity: Int,
    val imageUrls: List<String>,
    val sku: String,
    val isActive: Boolean
)

