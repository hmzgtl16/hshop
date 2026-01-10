package com.example.hshop.dto

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val message: String,
    val errors: List<String>? = null,
    val timestamp: Long
)