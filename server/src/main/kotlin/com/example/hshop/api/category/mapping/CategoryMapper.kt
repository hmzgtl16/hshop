package com.example.hshop.api.category.mapping

import com.example.hshop.api.category.api.dto.CategoryDto
import com.example.hshop.api.category.api.dto.CreateCategoryRequest
import com.example.hshop.api.category.api.dto.UpdateCategoryRequest
import com.example.hshop.api.category.domain.Category
import org.springframework.stereotype.Component

@Component
class CategoryMapper {

    fun toDto(category: Category): CategoryDto = CategoryDto(
        id = category.id!!,
        name = category.name,
        description = category.description,
        parentId = category.parentId,
        isActive = category.isActive
    )

    fun createModel(request: CreateCategoryRequest): Category = Category(
        name = request.name,
        description = request.description,
        parentId = request.parentId
    )

    fun updateModel(category: Category, request: UpdateCategoryRequest): Category = category.copy(
        name = request.name ?: category.name,
        description = request.description ?: category.description,
        parentId = request.parentId ?: category.parentId,
        isActive = request.isActive ?: category.isActive
    )
}