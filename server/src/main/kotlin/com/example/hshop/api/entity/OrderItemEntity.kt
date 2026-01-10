package com.example.hshop.api.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("order_items")
data class OrderItemEntity(
    @Id
    val id: UUID? = null,

    @Column("order_id")
    val orderId: UUID,

    @Column("product_id")
    val productId: UUID,

    @Column("product_name")
    val productName: String,

    @Column("quantity")
    val quantity: Int,

    @Column("price")
    val price: Double,

    @Column("subtotal")
    val subtotal: Double
)