package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val country: String
)