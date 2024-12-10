package server.driven.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.serialization.json.Json
import server.driven.ui.components.RockText
import server.driven.ui.domain.Offers
import server.driven.ui.ui.RockScreen
import server.driven.ui.widgets.OfferWidget

class MainActivity : ComponentActivity() {

    private val jsonConfig = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val offer =
            jsonConfig.decodeFromString<Offers>(
                """
                    {
                      "id": 1,
                      "name": "Offer A",
                      "type": "TypeA"
                    }
                    """
            )

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
            App(content = {

                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    RockText(text = "Dados do Backend e Componente no Mobile")

                    OfferWidget(offer)

                    Divider(
                        color = Color.Green,
                        thickness = 10.dp,
                        modifier = Modifier.padding(8.dp)
                    )

                    // BFF-HOME

                    Divider(
                        color = Color.Green,
                        thickness = 10.dp,
                        modifier = Modifier.padding(8.dp)
                    )

                    RockText(text = "Dados do Backend, incluindo formatação e dados")

                    RockScreen(sdui.root).render()
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