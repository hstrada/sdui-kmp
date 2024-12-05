package server.driven.ui

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform