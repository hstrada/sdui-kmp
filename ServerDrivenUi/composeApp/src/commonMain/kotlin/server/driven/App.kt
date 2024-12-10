package server.driven

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import server.driven.ui.RockScreen

import serverdrivenui.composeapp.generated.resources.Res
import serverdrivenui.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    val jsonConfig = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    val sdui =
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
                        "content" : 
                            {
                            "title": {
                            "id": "title",
                            "name": "title",
                            "element": {
                              "type": "widget",
                              "name": "text",
                              "properties": {
                                "text" : "Hello World da SDUI",
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
                                    "text" : "Isso é uma linha com um botão",
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

    MaterialTheme {
        RockScreen(sdui.root).render()
    }
}