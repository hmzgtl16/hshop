package com.example.hshop.api.product.domain

import com.example.hshop.dto.ProductDto
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table("products")
data class Product(
    @Id
    val id: UUID? = null,

    @Column("name")
    val name: String,

    @Column("description")
    val description: String,

    @Column("price")
    val price: Double,

    @Column("category_id")
    val categoryId: UUID,

    @Column("stock_quantity")
    val stockQuantity: Int,

    // Store as JSON array in PostgreSQL
    @Column("image_urls")
    val imageUrls: String, // JSON string: ["url1", "url2"]

    @Column("sku")
    val sku: String,

    @Column("is_active")
    val isActive: Boolean = true,

    @CreatedDate
    @Column("created_at")
    val createdAt: Instant = Instant.now(),

    @LastModifiedDate
    @Column("updated_at")
    val updatedAt: Instant = Instant.now()
)