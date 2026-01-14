package com.example.hshop.api.category.api.dto

import com.example.hshop.api.product.api.dto.UUIDSerializer
import com.example.hshop.constants.BusinessConstants
import com.example.hshop.constants.ErrorMessages
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class CategoryDto(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val description: String,
    @Serializable(with = UUIDSerializer::class)
    @SerialName(value = "parent-id") val parentId: UUID?,
    @SerialName(value = "is-active") val isActive: Boolean
)

@Serializable
data class CreateCategoryRequest(
    @field:NotBlank(message = ErrorMessages.CATEGORY_NAME_NOT_BLANK)
    @field:Size(
        min = BusinessConstants.CATEGORY_NAME_MIN_LENGTH,
        max = BusinessConstants.CATEGORY_NAME_MAX_LENGTH,
        message = ErrorMessages.CATEGORY_NAME_SIZE_CONSTRAINT
    )
    val name: String,
    @field:NotBlank(message = ErrorMessages.CATEGORY_DESCRIPTION_NOT_BLANK)
    @field:Size(
        min = BusinessConstants.CATEGORY_DESCRIPTION_MIN_LENGTH,
        max = BusinessConstants.CATEGORY_DESCRIPTION_MAX_LENGTH,
        message = ErrorMessages.CATEGORY_DESCRIPTION_SIZE_CONSTRAINT
    )
    val description: String,
    @Serializable(with = UUIDSerializer::class)
    @SerialName(value = "parent-id") val parentId: UUID? = null
)

@Serializable
data class UpdateCategoryRequest(
    @field:Size(
        min = BusinessConstants.CATEGORY_NAME_MIN_LENGTH,
        max = BusinessConstants.CATEGORY_NAME_MAX_LENGTH,
        message = ErrorMessages.CATEGORY_NAME_SIZE_CONSTRAINT
    )
    val name: String? = null,
    @field:Size(
        min = BusinessConstants.CATEGORY_DESCRIPTION_MIN_LENGTH,
        max = BusinessConstants.CATEGORY_DESCRIPTION_MAX_LENGTH,
        message = ErrorMessages.CATEGORY_DESCRIPTION_SIZE_CONSTRAINT
    )
    val description: String? = null,
    @Serializable(with = UUIDSerializer::class)
    @SerialName(value = "parent-id")
    val parentId: UUID? = null,
    @SerialName(value = "is-active")
    val isActive: Boolean? = null
)

@Serializable
data class CategorySearchRequest(
    val query: String? = null
)