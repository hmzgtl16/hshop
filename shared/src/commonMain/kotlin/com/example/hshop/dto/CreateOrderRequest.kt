package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class CreateOrderRequest(
    val shippingAddress: AddressDto,
    val paymentMethod: String
)