package com.example.hshop.api.repository

import com.example.hshop.api.entity.CartItemEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CartItemRepository : CoroutineCrudRepository<CartItemEntity, UUID> {
}