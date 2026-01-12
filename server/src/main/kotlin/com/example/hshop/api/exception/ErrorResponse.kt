package com.example.hshop.api.exception

import kotlin.time.Clock
import kotlin.time.Instant
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val timestamp: Instant = Clock.System.now(),
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)