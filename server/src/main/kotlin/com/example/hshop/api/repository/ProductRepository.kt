package com.example.hshop.api.repository

import com.example.hshop.api.entity.ProductEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface ProductRepository : CoroutineCrudRepository<ProductEntity, UUID> {
}