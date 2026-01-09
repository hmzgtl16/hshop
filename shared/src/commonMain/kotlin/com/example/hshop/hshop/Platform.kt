package com.example.hshop.hshop

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform