package com.example.hshop.api.repository

import com.example.hshop.api.entity.OrderItemEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface OrderItemRepository : CoroutineCrudRepository<OrderItemEntity, UUID> {
}