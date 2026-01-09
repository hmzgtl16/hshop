package com.example.hshop.domain.model

import kotlinx.serialization.Serializable

// shared/src/commonMain/kotlin/com/ecommerce/shared/domain/models/Category.kt
@Serializable
data class Category(
    val id: String,
    val name: String,
    val description: String,
    val parentId: String? = null,
    val isActive: Boolean = true,
    val createdAt: Long,
    val updatedAt: Long
)