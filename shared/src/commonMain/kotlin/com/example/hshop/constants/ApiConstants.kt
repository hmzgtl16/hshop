package com.example.hshop.constants

object ApiConstants {
    const val API_VERSION = "v1"
    const val BASE_PATH = "/api/$API_VERSION"

    // Auth endpoints
    const val AUTH_BASE = "$BASE_PATH/auth"
    const val LOGIN = "$AUTH_BASE/login"
    const val REGISTER = "$AUTH_BASE/register"
    const val REFRESH_TOKEN = "$AUTH_BASE/refresh"
    const val LOGOUT = "$AUTH_BASE/logout"

    // Product endpoints
    const val PRODUCTS_BASE = "$BASE_PATH/products"
    const val PRODUCT_BY_ID = "$PRODUCTS_BASE/{id}"
    const val PRODUCT_SEARCH = "$PRODUCTS_BASE/search"
    const val PRODUCTS_BY_CATEGORY = "$PRODUCTS_BASE/category/{categoryId}"

    // Category endpoints
    const val CATEGORIES_BASE = "$BASE_PATH/categories"
    const val CATEGORY_BY_ID = "$CATEGORIES_BASE/{id}"
    const val CATEGORY_PRODUCTS = "$CATEGORIES_BASE/{id}/products"

    // Cart endpoints
    const val CART_BASE = "$BASE_PATH/cart"
    const val CART_ITEMS = "$CART_BASE/items"
    const val CART_ITEM_BY_ID = "$CART_BASE/items/{id}"
    const val CART_CLEAR = "$CART_BASE/clear"

    // Order endpoints
    const val ORDERS_BASE = "$BASE_PATH/orders"
    const val ORDER_BY_ID = "$ORDERS_BASE/{id}"
    const val ORDER_HISTORY = "$ORDERS_BASE/history"
    const val ORDER_STATUS = "$ORDERS_BASE/{id}/status"

    // Admin endpoints
    const val ADMIN_BASE = "$BASE_PATH/admin"
    const val ADMIN_PRODUCTS = "$ADMIN_BASE/products"
    const val ADMIN_PRODUCT_BY_ID = "$ADMIN_PRODUCTS/{id}"
    const val ADMIN_PRODUCT_STOCK = "$ADMIN_PRODUCTS/{id}/stock"
    const val ADMIN_CATEGORIES = "$ADMIN_BASE/categories"
    const val ADMIN_CATEGORY_BY_ID = "$ADMIN_CATEGORIES/{id}"
    const val ADMIN_ORDERS = "$ADMIN_BASE/orders"
    const val ADMIN_ORDER_STATUS = "$ADMIN_ORDERS/{id}/status"
}

