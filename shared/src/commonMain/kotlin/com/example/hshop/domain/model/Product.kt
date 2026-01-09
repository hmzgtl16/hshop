package com.example.hshop.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val categoryId: String,
    val stockQuantity: Int,
    val imageUrls: List<String>,
    val sku: String,
    val isActive: Boolean = true,
    val createdAt: Long,
    val updatedAt: Long
)
