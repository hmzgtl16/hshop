package com.example.hshop.api.product.service

import com.example.hshop.api.product.api.dto.CreateProductRequest
import com.example.hshop.api.product.api.dto.ProductDto
import com.example.hshop.api.product.api.dto.ProductSearchRequest
import com.example.hshop.api.product.api.dto.UpdateProductRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.UUID

interface ProductService {

    fun createProduct(request: CreateProductRequest): ProductDto
    fun getProduct(id: UUID): ProductDto
    fun updateProduct(id: UUID, request: UpdateProductRequest): ProductDto
    fun deleteProduct(id: UUID)
    fun listProducts(pageable: Pageable): Page<ProductDto>
    fun findByCategory(categoryId: UUID, pageable: Pageable): Page<ProductDto>
    fun searchProducts(request: ProductSearchRequest, pageable: Pageable): Page<ProductDto>
}

