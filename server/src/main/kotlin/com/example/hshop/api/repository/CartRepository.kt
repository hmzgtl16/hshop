package com.example.hshop.api.repository

import com.example.hshop.api.entity.CartEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CartRepository : CoroutineCrudRepository<CartEntity, UUID> {
}