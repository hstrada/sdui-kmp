package server.driven.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.serialization.json.Json
import server.driven.ui.ui.RockScreen

class MainActivity : ComponentActivity() {

    private val jsonConfig = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val c =
            jsonConfig.decodeFromString<RockScreen>(
                """
                  {
                    "root": {
                        "id": "screen",
                        "name": "screen",
                        "element": {
                          "type": "layout",
                          "name": "column",
                          "properties": {
                            "padding": "12px"
                          }
                        },
                        "children": ["title", "row"],
                        "content" : {
                            "title": {
                            "id": "title",
                            "name": "title",
                            "element": {
                              "type": "widget",
                              "name": "text",
                              "properties": {
                                "text" : "Hello World",
                                "color": "greenStone"
                              }
                            }
                         },
                         "row": {
                            "id": "row",
                            "name": "row",
                            "element": {
                              "type": "layout",
                              "name": "row"
                            },
                            "children": ["subtitle", "primary"],
                            "content": {
                              "subtitle": {
                                "id": "subtitle",
                                "name": "subtitle",
                                "element": {
                                  "type": "widget",
                                  "name": "text",
                                  "properties": {
                                    "text" : "Hello World Subtitle",
                                    "color": "greenStone"
                                  }
                                }
                             },
                             "primary": {
                                "id": "primary",
                                "name": "primary",
                                "element": {
                                  "type": "widget",
                                  "name": "button",
                                  "properties": {
                                    "text" : "Clique Aqui"
                                  },
                                  "action": {
                                    "onPress": "xpto"
                                  }
                                }
                             }
                            }
                         }
                        }
                      }
                  }
                """.trimIndent()
            )

        setContent {
            App(content = { RockScreen(c.root).render() })
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