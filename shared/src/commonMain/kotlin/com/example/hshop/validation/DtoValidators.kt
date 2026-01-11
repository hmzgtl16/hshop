package com.example.hshop.validation

import com.example.hshop.dto.*

object DtoValidators {

    fun validateLoginRequest(request: LoginRequest): ValidationResult {
        val errors = mutableListOf<String>()

        val emailValidation = Validators.validateEmail(request.email)
        if (!emailValidation.isValid()) {
            errors.addAll(emailValidation.getValidationErrors())
        }

        if (request.password.isBlank()) {
            errors.add("Password is required")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateRegisterRequest(request: RegisterRequest): ValidationResult {
        val errors = mutableListOf<String>()

        val emailValidation = Validators.validateEmail(request.email)
        if (!emailValidation.isValid()) {
            errors.addAll(emailValidation.getValidationErrors())
        }

        val passwordValidation = Validators.validatePassword(request.password)
        if (!passwordValidation.isValid()) {
            errors.addAll(passwordValidation.getValidationErrors())
        }

        val firstNameValidation = Validators.validateName(request.firstName, "First name")
        if (!firstNameValidation.isValid()) {
            errors.addAll(firstNameValidation.getValidationErrors())
        }

        val lastNameValidation = Validators.validateName(request.lastName, "Last name")
        if (!lastNameValidation.isValid()) {
            errors.addAll(lastNameValidation.getValidationErrors())
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateCreateProductRequest(request: CreateProductRequest): ValidationResult {
        val errors = mutableListOf<String>()

        val nameValidation = Validators.validateName(request.name, "Product name")
        if (!nameValidation.isValid()) {
            errors.addAll(nameValidation.getValidationErrors())
        }

        val descriptionValidation = Validators.validateDescription(request.description, "Product description")
        if (!descriptionValidation.isValid()) {
            errors.addAll(descriptionValidation.getValidationErrors())
        }

        val priceValidation = Validators.validatePrice(request.price)
        if (!priceValidation.isValid()) {
            errors.addAll(priceValidation.getValidationErrors())
        }

        val stockValidation = Validators.validateStockQuantity(request.stockQuantity)
        if (!stockValidation.isValid()) {
            errors.addAll(stockValidation.getValidationErrors())
        }

        val skuValidation = Validators.validateSKU(request.sku)
        if (!skuValidation.isValid()) {
            errors.addAll(skuValidation.getValidationErrors())
        }

        val imageValidation = Validators.validateImageUrls(request.imageUrls)
        if (!imageValidation.isValid()) {
            errors.addAll(imageValidation.getValidationErrors())
        }

        if (request.categoryId.isBlank()) {
            errors.add("Category ID is required")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateUpdateProductRequest(request: UpdateProductRequest): ValidationResult {
        val errors = mutableListOf<String>()

        request.name?.let {
            val nameValidation = Validators.validateName(it, "Product name")
            if (!nameValidation.isValid()) {
                errors.addAll(nameValidation.getValidationErrors())
            }
        }

        request.description?.let {
            val descriptionValidation = Validators.validateDescription(it, "Product description")
            if (!descriptionValidation.isValid()) {
                errors.addAll(descriptionValidation.getValidationErrors())
            }
        }

        request.price?.let {
            val priceValidation = Validators.validatePrice(it)
            if (!priceValidation.isValid()) {
                errors.addAll(priceValidation.getValidationErrors())
            }
        }

        request.stockQuantity?.let {
            val stockValidation = Validators.validateStockQuantity(it)
            if (!stockValidation.isValid()) {
                errors.addAll(stockValidation.getValidationErrors())
            }
        }

        request.imageUrls?.let {
            val imageValidation = Validators.validateImageUrls(it)
            if (!imageValidation.isValid()) {
                errors.addAll(imageValidation.getValidationErrors())
            }
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateCreateCategoryRequest(request: CreateCategoryRequest): ValidationResult {
        val errors = mutableListOf<String>()

        val nameValidation = Validators.validateName(request.name, "Category name")
        if (!nameValidation.isValid()) {
            errors.addAll(nameValidation.getValidationErrors())
        }

        if (request.description.isBlank()) {
            errors.add("Category description is required")
        } else if (request.description.length < 10) {
            errors.add("Category description must be at least 10 characters")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateUpdateCategoryRequest(request: UpdateCategoryRequest): ValidationResult {
        val errors = mutableListOf<String>()

        request.name?.let {
            val nameValidation = Validators.validateName(it, "Category name")
            if (!nameValidation.isValid()) {
                errors.addAll(nameValidation.getValidationErrors())
            }
        }

        request.description?.let {
            if (it.isBlank()) {
                errors.add("Category description cannot be blank")
            } else if (it.length < 10) {
                errors.add("Category description must be at least 10 characters")
            }
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateAddToCartRequest(request: AddToCartRequest): ValidationResult {
        val errors = mutableListOf<String>()

        if (request.productId.isBlank()) {
            errors.add("Product ID is required")
        }

        val quantityValidation = Validators.validateQuantity(request.quantity)
        if (!quantityValidation.isValid()) {
            errors.addAll(quantityValidation.getValidationErrors())
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateUpdateCartItemRequest(request: UpdateCartItemRequest): ValidationResult {
        val errors = mutableListOf<String>()

        if (request.quantity < 0) {
            errors.add("Quantity cannot be negative")
        } else if (request.quantity > 99) {
            errors.add("Quantity cannot exceed 99 per item")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateCreateOrderRequest(request: CreateOrderRequest): ValidationResult {
        val errors = mutableListOf<String>()

        val addressValidation = Validators.validateAddress(request.shippingAddress)
        if (!addressValidation.isValid()) {
            errors.addAll(addressValidation.getValidationErrors())
        }

        if (request.paymentMethod.isBlank()) {
            errors.add("Payment method is required")
        } else {
            val validMethods = listOf("CREDIT_CARD", "DEBIT_CARD", "PAYPAL", "CASH_ON_DELIVERY")
            if (request.paymentMethod !in validMethods) {
                errors.add("Invalid payment method. Must be one of: ${validMethods.joinToString()}")
            }
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateUpdateOrderStatusRequest(request: UpdateOrderStatusRequest): ValidationResult {
        val errors = mutableListOf<String>()

        if (request.status.isBlank()) {
            errors.add("Order status is required")
        } else {
            val validStatuses = listOf(
                "PENDING", "CONFIRMED", "PROCESSING",
                "SHIPPED", "DELIVERED", "CANCELLED", "REFUNDED"
            )
            if (request.status !in validStatuses) {
                errors.add("Invalid order status. Must be one of: ${validStatuses.joinToString()}")
            }
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }
}