package com.example.hshop.constants

object ErrorMessages {
    // General errors
    const val UNAUTHORIZED = "Unauthorized access"
    const val FORBIDDEN = "Access forbidden"
    const val NOT_FOUND = "Resource not found"
    const val INVALID_REQUEST = "Invalid request"
    const val INTERNAL_ERROR = "Internal server error"
    const val BAD_REQUEST = "Bad request"

    // Authentication errors
    const val INVALID_CREDENTIALS = "Invalid email or password"
    const val EMAIL_ALREADY_EXISTS = "Email already exists"
    const val INVALID_TOKEN = "Invalid or expired token"
    const val INVALID_REFRESH_TOKEN = "Invalid or expired refresh token"
    const val TOKEN_EXPIRED = "Token has expired"
    const val USER_NOT_AUTHENTICATED = "User not authenticated"

    // User errors
    const val USER_NOT_FOUND = "User not found"
    const val INVALID_EMAIL = "Invalid email format"
    const val WEAK_PASSWORD = "Password does not meet requirements"

    // Product errors
    const val PRODUCT_NOT_FOUND = "Product not found"
    const val PRODUCT_OUT_OF_STOCK = "Product is out of stock"
    const val INSUFFICIENT_STOCK = "Insufficient stock available"
    const val INVALID_PRODUCT_DATA = "Invalid product data"
    const val DUPLICATE_SKU = "SKU already exists"
    const val INVALID_PRICE = "Invalid price"
    const val INVALID_STOCK_QUANTITY = "Invalid stock quantity"

    // Category errors
    const val CATEGORY_NOT_FOUND = "Category not found"
    const val CATEGORY_HAS_PRODUCTS = "Cannot delete category with existing products"
    const val CATEGORY_HAS_SUBCATEGORIES = "Cannot delete category with existing subcategories"
    const val CIRCULAR_CATEGORY_REFERENCE = "Cannot set parent category: would create circular reference"
    const val INVALID_CATEGORY_DEPTH = "Maximum category depth exceeded"

    // Cart errors
    const val CART_EMPTY = "Cart is empty"
    const val CART_NOT_FOUND = "Cart not found"
    const val CART_ITEM_NOT_FOUND = "Cart item not found"
    const val MAX_CART_ITEMS_REACHED = "Maximum cart items limit reached"
    const val MAX_QUANTITY_EXCEEDED = "Maximum quantity per item exceeded"
    const val INVALID_QUANTITY = "Invalid quantity"

    // Order errors
    const val ORDER_NOT_FOUND = "Order not found"
    const val INVALID_ORDER_STATUS = "Invalid order status"
    const val CANNOT_CANCEL_ORDER = "Order cannot be cancelled"
    const val ORDER_ALREADY_CANCELLED = "Order has already been cancelled"
    const val ORDER_ALREADY_DELIVERED = "Order has already been delivered"
    const val INVALID_SHIPPING_ADDRESS = "Invalid shipping address"
    const val INVALID_PAYMENT_METHOD = "Invalid payment method"
    const val ORDER_AMOUNT_TOO_LOW = "Order amount below minimum required"
    const val ORDER_AMOUNT_TOO_HIGH = "Order amount exceeds maximum allowed"

    // Validation errors
    const val REQUIRED_FIELD = "This field is required"
    const val FIELD_TOO_SHORT = "Field is too short"
    const val FIELD_TOO_LONG = "Field is too long"
    const val INVALID_FORMAT = "Invalid format"
    const val INVALID_URL = "Invalid URL format"

    // Admin errors
    const val ADMIN_ACCESS_REQUIRED = "Admin access required"
    const val CANNOT_DELETE_OWN_ACCOUNT = "Cannot delete your own account"
}