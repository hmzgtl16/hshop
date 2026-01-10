package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class UpdateCategoryRequest(
    val name: String? = null,
    val description: String? = null,
    val parentId: String? = null,
    val isActive: Boolean? = null
)