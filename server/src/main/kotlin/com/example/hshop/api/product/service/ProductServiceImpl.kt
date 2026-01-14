package com.example.hshop.api.product.service

import com.example.hshop.api.exception.EntityNotFoundException
import com.example.hshop.api.exception.InvalidRequestException
import com.example.hshop.api.product.api.dto.CreateProductRequest
import com.example.hshop.api.product.api.dto.ProductDto
import com.example.hshop.api.product.api.dto.ProductSearchRequest
import com.example.hshop.api.product.api.dto.UpdateProductRequest
import com.example.hshop.api.product.domain.ProductRepository
import com.example.hshop.api.product.mapping.ProductMapper
import com.example.hshop.api.category.domain.CategoryRepository
import com.example.hshop.constants.ErrorMessages
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ProductServiceImpl(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository,
    private val productMapper: ProductMapper
): ProductService {

    @Transactional
    override fun createProduct(
        request: CreateProductRequest
    ): ProductDto {

        if (!categoryRepository.existsById(request.categoryId))
            throw EntityNotFoundException(message = "Category not found")

        if (productRepository.existsBySku(request.sku))
            throw InvalidRequestException(message = "SKU already exists")

        val product = productMapper.toModel(request = request)

        return productMapper.toDto(product = productRepository.save(product))
    }

    @Transactional(readOnly = true)
    override fun getProduct(
        id: UUID
    ): ProductDto = productRepository
        .findById(id)
        .map(productMapper::toDto)
        .orElseThrow { EntityNotFoundException(message = ErrorMessages.PRODUCT_NOT_FOUND) }

    @Transactional
    override fun updateProduct(
        id: UUID,
        request: UpdateProductRequest
    ): ProductDto {
        val product = productRepository.findById(id)
            .orElseThrow{ EntityNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND) }

        val updatedProduct = productMapper.updateModel(product = product, request = request)
        return productMapper.toDto(product = productRepository.save(updatedProduct))
    }

    @Transactional
    override fun deleteProduct(id: UUID) {
        if (!productRepository.existsById(id)) {
            throw EntityNotFoundException(message = ErrorMessages.PRODUCT_NOT_FOUND)
        }
        productRepository.deleteById(id)
    }

    @Transactional(readOnly = true)
    override fun listProducts(
        pageable: Pageable
    ): Page<ProductDto> = productRepository
        .findAll(pageable)
        .map(productMapper::toDto)

    @Transactional(readOnly = true)
    override fun findByCategory(
        categoryId: UUID,
        pageable: Pageable
    ): Page<ProductDto> = productRepository
        .findAllByCategoryId(categoryId, pageable)
        .map(productMapper::toDto)

    @Transactional(readOnly = true)
    override fun searchProducts(
        request: ProductSearchRequest,
        pageable: Pageable
    ): Page<ProductDto> = productRepository
        .findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseAndPriceBetweenAndStockQuantityGreaterThanEqualAndActive(
            nameQuery = request.query,
            descriptionQuery = request.query,
            minPrice = request.minPrice,
            maxPrice = request.maxPrice,
            stockQuantity = if (request.inStock) 1 else 0,
            isActive = true,
            pageable = pageable
        )
        .map(productMapper::toDto)
}