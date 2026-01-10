package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class OrderDto(
    val id: String,
    val userId: String,
    val items: List<OrderItemDto>,
    val totalAmount: Double,
    val status: String,
    val shippingAddress: AddressDto,
    val paymentMethod: String,
    val createdAt: Long
)

