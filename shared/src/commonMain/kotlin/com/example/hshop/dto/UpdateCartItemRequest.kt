package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class UpdateCartItemRequest(
    val quantity: Int
)