package com.example.hshop.api.category.service

import com.example.hshop.api.category.api.dto.CategoryDto
import com.example.hshop.api.category.api.dto.CreateCategoryRequest
import com.example.hshop.api.category.api.dto.UpdateCategoryRequest
import com.example.hshop.api.category.api.dto.CategorySearchRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface CategoryService {

    fun createCategory(request: CreateCategoryRequest): CategoryDto
    fun getCategory(id: UUID): CategoryDto
    fun updateCategory(id: UUID, request: UpdateCategoryRequest): CategoryDto
    fun deleteCategory(id: UUID)
    fun listCategories(pageable: Pageable): Page<CategoryDto>
    fun searchCategories(request: CategorySearchRequest, pageable: Pageable): Page<CategoryDto>
}