package com.example.kmmcoinapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform