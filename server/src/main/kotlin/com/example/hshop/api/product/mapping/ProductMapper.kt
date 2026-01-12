package com.example.hshop.api.product.mapping

import com.example.hshop.api.product.domain.Product
import com.example.hshop.api.product.api.dto.CreateProductRequest
import com.example.hshop.api.product.api.dto.ProductDto
import com.example.hshop.api.product.api.dto.UpdateProductRequest
import org.springframework.stereotype.Component

@Component
class ProductMapper {

    fun toDto(product: Product): ProductDto = ProductDto(
        id = product.id!!,
        name = product.name,
        description = product.description,
        price = product.price,
        categoryId = product.categoryId,
        stockQuantity = product.stockQuantity,
        imageUrls = product.getImageUrlsList(),
        sku = product.sku,
        isActive = product.isActive
    )

    fun toModel(request: CreateProductRequest): Product = Product(
        name = request.name,
        description = request.description,
        price = request.price,
        categoryId = request.categoryId,
        stockQuantity = request.stockQuantity,
        imageUrls = fromImageUrlsList(request.imageUrls),
        sku = request.sku
    )

    fun updateModel(
        product: Product,
        request: UpdateProductRequest
    ): Product = product.copy(
        name = request.name ?: product.name,
        description = request.description ?: product.description,
        price = request.price ?: product.price,
        stockQuantity = request.stockQuantity ?: product.stockQuantity,
        imageUrls = request.imageUrls?.let(::fromImageUrlsList) ?: product.imageUrls,
        isActive = request.isActive ?: product.isActive
    )

}

fun Product.getImageUrlsList(): List<String> {
    return if (imageUrls.isBlank()) emptyList()
    else imageUrls.removeSurrounding("[", "]")
        .split(",")
        .map { it.trim().removeSurrounding("\"") }
        .filter { it.isNotBlank() }
}

fun fromImageUrlsList(urls: List<String>): String =
    urls.joinToString(",", "[", "]") { "\"$it\"" }