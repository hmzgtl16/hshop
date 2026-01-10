package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductSearchRequest(
    val query: String? = null,
    val categoryId: String? = null,
    val minPrice: Double? = null,
    val maxPrice: Double? = null,
    val inStock: Boolean? = null,
    val page: Int = 0,
    val size: Int = 20
)