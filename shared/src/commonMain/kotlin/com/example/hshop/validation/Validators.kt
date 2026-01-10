package com.example.hshop.validation

import com.example.hshop.dto.AddressDto

object Validators {

    fun validateEmail(email: String): ValidationResult {
        val errors = mutableListOf<String>()

        if (email.isBlank()) {
            errors.add("Email is required")
        } else {
            val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
            if (!emailRegex.matches(email)) {
                errors.add("Invalid email format")
            }
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validatePassword(password: String): ValidationResult {
        val errors = mutableListOf<String>()

        if (password.isBlank()) {
            errors.add("Password is required")
        } else {
            if (password.length < 8) {
                errors.add("Password must be at least 8 characters")
            }
            if (!password.any { it.isUpperCase() }) {
                errors.add("Password must contain at least one uppercase letter")
            }
            if (!password.any { it.isLowerCase() }) {
                errors.add("Password must contain at least one lowercase letter")
            }
            if (!password.any { it.isDigit() }) {
                errors.add("Password must contain at least one digit")
            }
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateName(name: String, fieldName: String): ValidationResult {
        val errors = mutableListOf<String>()

        if (name.isBlank()) {
            errors.add("$fieldName is required")
        } else if (name.length < 2) {
            errors.add("$fieldName must be at least 2 characters")
        } else if (name.length > 50) {
            errors.add("$fieldName must not exceed 50 characters")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validatePrice(price: Double): ValidationResult {
        val errors = mutableListOf<String>()

        if (price < 0) {
            errors.add("Price cannot be negative")
        } else if (price == 0.0) {
            errors.add("Price must be greater than 0")
        } else if (price > 1000000) {
            errors.add("Price cannot exceed 1,000,000")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateQuantity(quantity: Int): ValidationResult {
        val errors = mutableListOf<String>()

        if (quantity < 0) {
            errors.add("Quantity cannot be negative")
        } else if (quantity == 0) {
            errors.add("Quantity must be greater than 0")
        } else if (quantity > 99) {
            errors.add("Quantity cannot exceed 99 per item")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateStockQuantity(quantity: Int): ValidationResult {
        val errors = mutableListOf<String>()

        if (quantity < 0) {
            errors.add("Stock quantity cannot be negative")
        } else if (quantity > 100000) {
            errors.add("Stock quantity cannot exceed 100,000")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateSKU(sku: String): ValidationResult {
        val errors = mutableListOf<String>()

        if (sku.isBlank()) {
            errors.add("SKU is required")
        } else if (sku.length < 3) {
            errors.add("SKU must be at least 3 characters")
        } else if (sku.length > 50) {
            errors.add("SKU must not exceed 50 characters")
        } else if (!sku.matches("^[A-Z0-9-]+$".toRegex())) {
            errors.add("SKU can only contain uppercase letters, numbers, and hyphens")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateDescription(description: String, fieldName: String = "Description"): ValidationResult {
        val errors = mutableListOf<String>()

        if (description.isBlank()) {
            errors.add("$fieldName is required")
        } else if (description.length < 10) {
            errors.add("$fieldName must be at least 10 characters")
        } else if (description.length > 5000) {
            errors.add("$fieldName must not exceed 5000 characters")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateAddress(address: AddressDto): ValidationResult {
        val errors = mutableListOf<String>()

        if (address.street.isBlank()) {
            errors.add("Street is required")
        } else if (address.street.length < 5) {
            errors.add("Street must be at least 5 characters")
        }

        if (address.city.isBlank()) {
            errors.add("City is required")
        } else if (address.city.length < 2) {
            errors.add("City must be at least 2 characters")
        }

        if (address.state.isBlank()) {
            errors.add("State is required")
        }

        if (address.zipCode.isBlank()) {
            errors.add("Zip code is required")
        } else if (address.zipCode.length < 3) {
            errors.add("Zip code must be at least 3 characters")
        }

        if (address.country.isBlank()) {
            errors.add("Country is required")
        } else if (address.country.length < 2) {
            errors.add("Country must be at least 2 characters")
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }

    fun validateImageUrls(urls: List<String>): ValidationResult {
        val errors = mutableListOf<String>()

        if (urls.isEmpty()) {
            errors.add("At least one image URL is required")
        } else {
            urls.forEachIndexed { index, url ->
                if (url.isBlank()) {
                    errors.add("Image URL at position ${index + 1} cannot be blank")
                } else if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    errors.add("Image URL at position ${index + 1} must start with http:// or https://")
                }
            }
        }

        return if (errors.isEmpty()) ValidationResult.Valid else ValidationResult.Invalid(errors)
    }
}