package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class AddToCartRequest(
    val productId: String,
    val quantity: Int
)