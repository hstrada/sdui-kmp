package server.driven.ui.config

import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import server.driven.ui.components.RockColumn
import server.driven.ui.components.RockComponent
import server.driven.ui.components.RockText

object JsonConfig {
    val jsonSerializersModule = SerializersModule {
        polymorphic(RockComponent::class) {
            subclass(RockText::class)
            subclass(RockColumn::class)
        }
    }
}