package com.example.hshop.constants

object BusinessConstants {
    // Cart limits
    const val MAX_CART_ITEMS = 100
    const val MAX_QUANTITY_PER_ITEM = 99
    const val MIN_QUANTITY = 1

    // Order limits
    const val MIN_ORDER_AMOUNT = 5.0
    const val MAX_ORDER_AMOUNT = 50000.0

    // Pagination
    const val DEFAULT_PAGE_SIZE = 20
    const val MAX_PAGE_SIZE = 100
    const val MIN_PAGE_SIZE = 1

    // Authentication
    const val TOKEN_EXPIRATION_HOURS = 24
    const val REFRESH_TOKEN_EXPIRATION_DAYS = 30
    const val MIN_PASSWORD_LENGTH = 8
    const val MAX_PASSWORD_LENGTH = 100

    // Product constraints
    const val MIN_PRODUCT_NAME_LENGTH = 3
    const val MAX_PRODUCT_NAME_LENGTH = 200
    const val MIN_DESCRIPTION_LENGTH = 10
    const val MAX_DESCRIPTION_LENGTH = 5000
    const val MAX_PRODUCT_IMAGES = 10
    const val MIN_PRODUCT_PRICE = 0.01
    const val MAX_PRODUCT_PRICE = 1000000.0

    // Stock management
    const val LOW_STOCK_THRESHOLD = 10
    const val OUT_OF_STOCK = 0
    const val MAX_STOCK_QUANTITY = 100000

    // Category constraints
    const val MIN_CATEGORY_NAME_LENGTH = 2
    const val MAX_CATEGORY_NAME_LENGTH = 100
    const val MAX_CATEGORY_DEPTH = 5

    // SKU format
    const val MIN_SKU_LENGTH = 3
    const val MAX_SKU_LENGTH = 50
    const val SKU_PATTERN = "^[A-Z0-9-]+$"

    // Address constraints
    const val MIN_STREET_LENGTH = 5
    const val MAX_STREET_LENGTH = 200
    const val MIN_CITY_LENGTH = 2
    const val MAX_CITY_LENGTH = 100
    const val MIN_ZIP_LENGTH = 3
    const val MAX_ZIP_LENGTH = 20
}