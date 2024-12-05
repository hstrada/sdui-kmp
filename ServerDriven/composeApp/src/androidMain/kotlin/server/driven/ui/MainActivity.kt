package server.driven.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.serialization.Polymorphic
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import server.driven.ui.components.RockColumn
import server.driven.ui.components.RockComponent
import server.driven.ui.components.RockText

class MainActivity : ComponentActivity() {
    private val appModule = SerializersModule {
        polymorphic(RockComponent::class) {
            subclass(RockText::class)
            subclass(RockColumn::class)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Json {
            serializersModule = appModule
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
            encodeDefaults = true
            classDiscriminator = "type"
        }

        val content =
            Json.decodeFromString<List<@Polymorphic RockComponent>>(
                """
                [
                  {"type": "RockText", "text":"Hello World1"}, 
                  {"type": "RockText", "text":"Hello World2"}
                ]
                """.trimIndent()
            )

        setContent {
            App(content = {
                Column {
                    content.forEach {
                        it.render()
                    }
                }
            })
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        App(content = {})
    }
}