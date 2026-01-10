package com.example.hshop.api.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table("categories")
data class CategoryEntity(
    @Id
    val id: UUID? = null,

    @Column("name")
    val name: String,

    @Column("description")
    val description: String,

    @Column("parent_id")
    val parentId: UUID? = null,

    @Column("is_active")
    val isActive: Boolean = true,

    @CreatedDate
    @Column("created_at")
    val createdAt: Instant = Instant.now(),

    @LastModifiedDate
    @Column("updated_at")
    val updatedAt: Instant = Instant.now()
)