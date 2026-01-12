package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductSearchRequest(
    val query: String? = null,
    val minPrice: Double = 0.0,
    val maxPrice: Double = Double.MAX_VALUE,
    val inStock: Boolean = false,
)