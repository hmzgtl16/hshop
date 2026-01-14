package com.example.hshop.api.category.api

import com.example.hshop.api.category.api.dto.CategoryDto
import com.example.hshop.api.category.api.dto.CategorySearchRequest
import com.example.hshop.api.category.api.dto.CreateCategoryRequest
import com.example.hshop.api.category.api.dto.UpdateCategoryRequest
import com.example.hshop.api.category.service.CategoryService
import com.example.hshop.constants.HttpStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api")
class CategoryController(
    private val categoryService: CategoryService
) {

    @PostMapping("/{version}/categories", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE')")
    fun createCategory(
        @RequestBody request: CreateCategoryRequest
    ): ResponseEntity<CategoryDto> = ResponseEntity
        .status(HttpStatus.CREATED)
        .body(categoryService.createCategory(request))
        
    @GetMapping("/{version}/categories/{id}", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE', 'CUSTOMER')")
    fun getCategory(
        @PathVariable id: UUID
    ): ResponseEntity<CategoryDto> = ResponseEntity
        .ok(categoryService.getCategory(id))

    @PutMapping("/{version}/categories/{id}", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE')")
    fun updateCategory(
        @PathVariable id: UUID,
        @RequestBody request: UpdateCategoryRequest
    ): ResponseEntity<CategoryDto> = ResponseEntity
        .ok(categoryService.updateCategory(id, request))

    @DeleteMapping("/{version}/categories/{id}", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER')")
    fun deleteCategory(
        @PathVariable id: UUID
    ): ResponseEntity<Unit> = ResponseEntity
        .noContent()
        .build()

    @GetMapping("/{version}/categories", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE', 'CUSTOMER')")
    fun listCategories(
         @PageableDefault(size = 20, sort = ["name"]) pageable: Pageable
    ): ResponseEntity<Page<CategoryDto>> = ResponseEntity
        .ok(categoryService.listCategories(pageable))

    @GetMapping("/{version}/categories/search", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE', 'CUSTOMER')")
    fun searchCategories(
        @PageableDefault(size = 20, sort = ["name"]) pageable: Pageable,
        @RequestBody request: CategorySearchRequest
    ): ResponseEntity<Page<CategoryDto>> = ResponseEntity
        .ok(categoryService.searchCategories(request, pageable))
}