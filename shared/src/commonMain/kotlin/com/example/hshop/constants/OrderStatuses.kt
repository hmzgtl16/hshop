package com.example.hshop.constants

object OrderStatuses {
    const val PENDING = "PENDING"
    const val CONFIRMED = "CONFIRMED"
    const val PROCESSING = "PROCESSING"
    const val SHIPPED = "SHIPPED"
    const val DELIVERED = "DELIVERED"
    const val CANCELLED = "CANCELLED"
    const val REFUNDED = "REFUNDED"

    val ALL = listOf(PENDING, CONFIRMED, PROCESSING, SHIPPED, DELIVERED, CANCELLED, REFUNDED)
    val ACTIVE = listOf(PENDING, CONFIRMED, PROCESSING, SHIPPED)
    val COMPLETED = listOf(DELIVERED)
    val TERMINAL = listOf(CANCELLED, REFUNDED, DELIVERED)
}