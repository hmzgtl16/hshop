package com.example.hshop.api.repository

import com.example.hshop.api.entity.CategoryEntity
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.UUID

interface CategoryRepository : CoroutineCrudRepository<CategoryEntity, UUID> {
}