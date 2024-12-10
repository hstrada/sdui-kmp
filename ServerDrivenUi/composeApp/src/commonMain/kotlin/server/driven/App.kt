package server.driven

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import kotlinx.serialization.json.Json
import org.jetbrains.compose.ui.tooling.preview.Preview
import server.driven.ui.RockScreen

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
                                "text" : "SDUI",
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
                                    "type": "DeepLink",
                                    "onPress": "xpto",
                                    "analytics": {
                                        "viewed": "",
                                        "clicked": ""
                                    }
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
