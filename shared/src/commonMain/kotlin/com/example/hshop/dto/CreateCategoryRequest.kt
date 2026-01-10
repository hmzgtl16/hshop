package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateCategoryRequest(
    val name: String,
    val description: String,
    val parentId: String? = null
)