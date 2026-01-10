package com.example.hshop.validation

sealed class ValidationResult {
    object Valid : ValidationResult()
    data class Invalid(val errors: List<String>) : ValidationResult()

    fun isValid() = this is Valid
    fun getErrors() = (this as? Invalid)?.errors ?: emptyList()
}