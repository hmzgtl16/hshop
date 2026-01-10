package com.example.hshop.api.repository

import com.example.hshop.api.entity.OrderEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface OrderRepository : CoroutineCrudRepository<OrderEntity, UUID> {
}