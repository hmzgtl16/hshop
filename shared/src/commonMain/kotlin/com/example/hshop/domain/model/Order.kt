package com.example.hshop.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val id: String,
    val userId: String,
    val items: List<OrderItem>,
    val totalAmount: Double,
    val status: OrderStatus,
    val shippingAddress: Address,
    val paymentMethod: PaymentMethod,
    val createdAt: Long,
    val updatedAt: Long
)

@Serializable
data class OrderItem(
    val id: String,
    val productId: String,
    val productName: String,
    val quantity: Int,
    val price: Double,
    val subtotal: Double
)

@Serializable
enum class OrderStatus {
    PENDING,
    CONFIRMED,
    PROCESSING,
    SHIPPED,
    DELIVERED,
    CANCELLED,
    REFUNDED
}

@Serializable
enum class PaymentMethod {
    CREDIT_CARD,
    DEBIT_CARD,
    PAYPAL,
    CASH_ON_DELIVERY
}

@Serializable
data class Address(
    val street: String,
    val city: String,
    val state: String,
    val zipCode: String,
    val country: String
)