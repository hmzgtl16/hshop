package com.example.hshop.api.product.api

import com.example.hshop.api.product.service.ProductService
import com.example.hshop.api.product.api.dto.CreateProductRequest
import com.example.hshop.api.product.api.dto.ProductDto
import com.example.hshop.api.product.api.dto.ProductSearchRequest
import com.example.hshop.api.product.api.dto.UpdateProductRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
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
class ProductController(
    private val productService: ProductService
) {

    @PostMapping("/{version}/products", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE')")
    fun createProduct(
        @RequestBody request: CreateProductRequest
    ): ResponseEntity<ProductDto> = ResponseEntity
        .status(HttpStatus.CREATED)
        .body(productService.createProduct(request))

    @GetMapping("/{version}/products/{id}", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE', 'CUSTOMER')")
    fun getProduct(
        @PathVariable id: UUID
    ): ResponseEntity<ProductDto> = ResponseEntity
        .ok(productService.getProduct(id))

    @PutMapping("/{version}/products/{id}", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE')")
    fun updateProduct(
        @PathVariable id: UUID,
        @RequestBody request: UpdateProductRequest
    ): ResponseEntity<ProductDto> = ResponseEntity
        .ok(productService.updateProduct(id, request))

    @DeleteMapping("/{version}/products/{id}", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER')")
    fun deleteProduct(
        @PathVariable id: UUID
    ): ResponseEntity<Unit> = ResponseEntity
        .noContent()
        .build()

    @GetMapping("/{version}/products", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE', 'CUSTOMER')")
    fun listProducts(
         @PageableDefault(size = 20, sort = ["name"]) pageable: Pageable
    ): ResponseEntity<Page<ProductDto>> = ResponseEntity
        .ok(productService.listProducts(pageable))

    @GetMapping("/{version}/products/search", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE', 'CUSTOMER')")
    fun searchProducts(
        @PageableDefault(size = 20, sort = ["name"]) pageable: Pageable,
        @RequestBody request: ProductSearchRequest
    ): ResponseEntity<Page<ProductDto>> = ResponseEntity
        .ok(productService.searchProducts(request, pageable))

    @GetMapping("/{version}/products/category/{categoryId}", version = "1.0")
    @PreAuthorize("hasAnyRole('ADMIN', 'SALES_MANAGER', 'SALES_REPRESENTATIVE', 'CUSTOMER')")
    fun findByCategory(
        @PathVariable categoryId: UUID,
        @PageableDefault(size = 20, sort = ["name"]) pageable: Pageable
    ): ResponseEntity<Page<ProductDto>> = ResponseEntity
        .ok(productService.findByCategory(categoryId, pageable))
}