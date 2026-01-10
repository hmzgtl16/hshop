package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class CartDto(
    val id: String,
    val items: List<CartItemDto>,
    val totalAmount: Double
)

