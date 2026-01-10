package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderItemDto(
    val id: String,
    val productId: String,
    val productName: String,
    val quantity: Int,
    val price: Double,
    val subtotal: Double
)