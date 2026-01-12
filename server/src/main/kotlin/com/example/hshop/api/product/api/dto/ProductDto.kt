package com.example.hshop.api.product.api.dto

import com.example.hshop.constants.BusinessConstants
import com.example.hshop.constants.ErrorMessages
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.PositiveOrZero
import jakarta.validation.constraints.Size
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.*

@Serializable
data class ProductDto(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val description: String,
    val price: Double,
    @Serializable(with = UUIDSerializer::class)
    @SerialName(value = "category-id") val categoryId: UUID,
    @SerialName(value = "stock-quantity") val stockQuantity: Int,
    @SerialName(value = "image-urls")val imageUrls: List<String>,
    val sku: String,
    @SerialName(value = "is-active")val isActive: Boolean
)

@Serializable
data class CreateProductRequest(
    @field:NotBlank(message = ErrorMessages.PRODUCT_NAME_NOT_BLANK)
    @field:Size(
        min = BusinessConstants.PRODUCT_NAME_MIN_LENGTH,
        max = BusinessConstants.PRODUCT_NAME_MAX_LENGTH,
        message = ErrorMessages.PRODUCT_NAME_SIZE_CONSTRAINT
    )
    val name: String,
    @field:NotBlank(message = ErrorMessages.PRODUCT_DESCRIPTION_NOT_BLANK)
    @field:Size(
        min = BusinessConstants.PRODUCT_DESCRIPTION_MIN_LENGTH,
        max = BusinessConstants.PRODUCT_DESCRIPTION_MAX_LENGTH,
        message = ErrorMessages.PRODUCT_DESCRIPTION_SIZE_CONSTRAINT
    )
    val description: String,
    @field:NotBlank(message = ErrorMessages.PRODUCT_PRICE_NOT_BLANK)
    @field:PositiveOrZero(message = ErrorMessages.PRODUCT_PRICE_POSITIVE)
    val price: Double,
    @field:NotBlank(message = ErrorMessages.PRODUCT_SKU_NOT_BLANK)
    @field:Size(
        min = BusinessConstants.PRODUCT_SKU_MIN_LENGTH,
        max = BusinessConstants.PRODUCT_SKU_MAX_LENGTH,
        message = ErrorMessages.PRODUCT_SKU_SIZE_CONSTRAINT
    )
    val sku: String,
    @Serializable(with = UUIDSerializer::class)
    @field:NotBlank(message = ErrorMessages.PRODUCT_CATEGORY_NOT_BLANK)
    @SerialName(value = "category-id")
    val categoryId: UUID,
    @field:NotBlank(message = ErrorMessages.PRODUCT_STOCK_QUANTITY_NOT_BLANK)
    @field:PositiveOrZero(message = ErrorMessages.PRODUCT_STOCK_QUANTITY_POSITIVE)
    @SerialName(value = "stock-quantity")
    val stockQuantity: Int,
    @field:Size(
        min = BusinessConstants.PRODUCT_IMAGES_MIN_NUMBER,
        max = BusinessConstants.PRODUCT_IMAGES_MAX_NUMBER,
        message = ErrorMessages.PRODUCT_IMAGES_NUMBER_CONSTRAINT
    )
    @SerialName(value = "image-urls")
    val imageUrls: List<String>,
)

@Serializable
data class UpdateProductRequest(
    @field:Size(
        min = BusinessConstants.PRODUCT_NAME_MIN_LENGTH,
        max = BusinessConstants.PRODUCT_NAME_MAX_LENGTH,
        message = ErrorMessages.PRODUCT_NAME_SIZE_CONSTRAINT
    )
    val name: String? = null,
    @field:Size(
        min = BusinessConstants.PRODUCT_DESCRIPTION_MIN_LENGTH,
        max = BusinessConstants.PRODUCT_DESCRIPTION_MAX_LENGTH,
        message = ErrorMessages.PRODUCT_DESCRIPTION_SIZE_CONSTRAINT
    )
    val description: String? = null,
    @field:NotBlank(message = ErrorMessages.PRODUCT_PRICE_NOT_BLANK)
    @field:PositiveOrZero(message = ErrorMessages.PRODUCT_PRICE_POSITIVE)
    val price: Double? = null,
    @field:Size(
        min = BusinessConstants.PRODUCT_SKU_MIN_LENGTH,
        max = BusinessConstants.PRODUCT_SKU_MAX_LENGTH,
        message = ErrorMessages.PRODUCT_SKU_SIZE_CONSTRAINT
    )
    val sku: String? = null,
    @Serializable(with = UUIDSerializer::class)
    @SerialName(value = "category-id")
    val categoryId: UUID? = null,
    @field:PositiveOrZero(message = ErrorMessages.PRODUCT_STOCK_QUANTITY_POSITIVE)
    @SerialName(value = "stock-quantity")
    val stockQuantity: Int? = null,
    @field:Size(
        min = BusinessConstants.PRODUCT_IMAGES_MIN_NUMBER,
        max = BusinessConstants.PRODUCT_IMAGES_MAX_NUMBER,
        message = ErrorMessages.PRODUCT_IMAGES_NUMBER_CONSTRAINT
    )
    @SerialName(value = "image-urls")
    val imageUrls: List<String> = emptyList(),
    @SerialName(value = "is-active")
    val isActive: Boolean? = null
)

@Serializable
data class ProductSearchRequest(
    val query: String? = null,
    val minPrice: Double = 0.0,
    val maxPrice: Double = Double.MAX_VALUE,
    val inStock: Boolean = false,
)

object UUIDSerializer : KSerializer<UUID> {
    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING) //

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString()) //
    }

    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString()) //
    }
}