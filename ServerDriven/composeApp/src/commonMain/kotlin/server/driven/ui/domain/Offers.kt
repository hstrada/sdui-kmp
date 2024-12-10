package server.driven.ui.domain

import kotlinx.serialization.Serializable

@Serializable
data class Offers(
    val id: Int,
    val name: String,
    val type: OfferType
) {
    enum class OfferType {
        TypeA, TypeB
    }
}