package com.example.hshop.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    val id: String,
    val userId: String,
    val items: List<CartItem>,
    val totalAmount: Double,
    val updatedAt: Long
)

@Serializable
data class CartItem(
    val id: String,
    val productId: String,
    val productName: String,
    val quantity: Int,
    val price: Double,
    val subtotal: Double
)