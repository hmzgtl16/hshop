package com.example.hshop.api.entity

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table("carts")
data class CartEntity(
    @Id
    val id: UUID? = null,

    @Column("user_id")
    val userId: UUID,

    @LastModifiedDate
    @Column("updated_at")
    val updatedAt: Instant = Instant.now()
)