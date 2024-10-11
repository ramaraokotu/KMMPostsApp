package com.kmm.postsapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform