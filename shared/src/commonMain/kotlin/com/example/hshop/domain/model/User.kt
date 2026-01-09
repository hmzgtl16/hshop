package com.example.hshop.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val role: UserRole,
    val createdAt: Long,
    val updatedAt: Long
)

@Serializable
enum class UserRole {
    CUSTOMER,
    ADMIN
}