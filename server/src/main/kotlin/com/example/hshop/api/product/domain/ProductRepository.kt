package com.example.hshop.api.product.domain

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ProductRepository : CrudRepository<Product, UUID>, PagingAndSortingRepository<Product, UUID> {

    fun existsBySku(sku: String): Boolean

    fun findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseAndPriceBetweenAndStockQuantityGreaterThanEqualAndActive(
        nameQuery: String?,
        descriptionQuery: String?,
        minPrice: Double = 0.0,
        maxPrice: Double = Double.MAX_VALUE,
        stockQuantity: Int,
        isActive: Boolean,
        pageable: Pageable
    ): Page<Product>

    fun findAllByCategoryId(categoryId: UUID, pageable: Pageable): Page<Product>
}