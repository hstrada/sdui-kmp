package server.driven

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform