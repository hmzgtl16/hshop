package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class UpdateProductRequest(
    val name: String? = null,
    val description: String? = null,
    val price: Double? = null,
    val categoryId: String? = null,
    val stockQuantity: Int? = null,
    val imageUrls: List<String>? = null,
    val isActive: Boolean? = null
)