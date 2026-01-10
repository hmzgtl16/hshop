package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto(
    val id: String,
    val name: String,
    val description: String,
    val parentId: String? = null,
    val parentName: String? = null,
    val isActive: Boolean
)

