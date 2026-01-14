package com.example.hshop.api.category.service

import com.example.hshop.api.category.api.dto.CategoryDto
import com.example.hshop.api.category.api.dto.CategorySearchRequest
import com.example.hshop.api.category.api.dto.CreateCategoryRequest
import com.example.hshop.api.category.api.dto.UpdateCategoryRequest
import com.example.hshop.api.category.domain.CategoryRepository
import com.example.hshop.api.category.mapping.CategoryMapper
import com.example.hshop.api.exception.EntityNotFoundException
import com.example.hshop.constants.ErrorMessages
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CategoryServiceImpl(
    private val categoryRepository: CategoryRepository,
    private val categoryMapper: CategoryMapper
) : CategoryService {

    @Transactional
    override fun createCategory(request: CreateCategoryRequest): CategoryDto {
        val category = categoryMapper.createModel(request = request)

        return categoryMapper.toDto(category = categoryRepository.save(category))
    }

    @Transactional(readOnly = true)
    override fun getCategory(
        id: UUID
    ): CategoryDto = categoryRepository
        .findById(id)
        .map(categoryMapper::toDto)
        .orElseThrow { EntityNotFoundException(message = ErrorMessages.CATEGORY_NOT_FOUND) }

    @Transactional
    override fun updateCategory(
        id: UUID,
        request: UpdateCategoryRequest
    ): CategoryDto {
        val category = categoryRepository.findById(id)
            .orElseThrow { EntityNotFoundException(ErrorMessages.CATEGORY_NOT_FOUND) }

        val updatedCategory = categoryMapper.updateModel(category = category, request = request)
        return categoryMapper.toDto(category = categoryRepository.save(updatedCategory))
    }

    @Transactional
    override fun deleteCategory(id: UUID) {
        if (!categoryRepository.existsById(id)) {
            throw EntityNotFoundException(message = ErrorMessages.CATEGORY_NOT_FOUND)
        }
        categoryRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    override fun listCategories(
        pageable: Pageable
    ): Page<CategoryDto> = categoryRepository
        .findAll(pageable)
        .map(categoryMapper::toDto)

    @Transactional(readOnly = true)
    override fun searchCategories(
        request: CategorySearchRequest,
        pageable: Pageable
    ): Page<CategoryDto> = categoryRepository
        .findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
            nameQuery = request.query,
            descriptionQuery = request.query,
            pageable = pageable
        )
        .map(categoryMapper::toDto)
}