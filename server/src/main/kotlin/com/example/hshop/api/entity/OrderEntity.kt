package com.example.hshop.api.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table("orders")
data class OrderEntity(
    @Id
    val id: UUID? = null,

    @Column("user_id")
    val userId: UUID,

    @Column("total_amount")
    val totalAmount: Double,

    @Column("status")
    val status: String, // Store enum as string

    // Address fields (embedded)
    @Column("street")
    val street: String,

    @Column("city")
    val city: String,

    @Column("state")
    val state: String,

    @Column("zip_code")
    val zipCode: String,

    @Column("country")
    val country: String,

    @Column("payment_method")
    val paymentMethod: String,

    @CreatedDate
    @Column("created_at")
    val createdAt: Instant = Instant.now(),

    @LastModifiedDate
    @Column("updated_at")
    val updatedAt: Instant = Instant.now()
)