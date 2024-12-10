package server.driven.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable
import server.driven.components.RockButton
import server.driven.components.RockText

@Serializable
data class RockElement(
    val type: String,
    val name: String,
    val properties: Map<String, String>? = emptyMap()
)

@Serializable
data class RockRoot(
    val id: String,
    val name: String,
    val element: RockElement,
    val children: List<String>? = null,
    val content: Map<String, RockRoot>? = null
)

@Serializable
data class RockScreen(
    val root: RockRoot
) {
    @Composable
    fun renderComponent(name: String, properties: Map<String, String>?) =
        when (name) {
            "text" -> properties?.get("text")?.let {
                RockText(text = it)
            }

            "button" -> properties?.get("action")?.let {
//                val onClick = when (it.get("type")) {
//                    "DeepLink" -> {}
//                    "URL" -> {}
//                }
                RockButton(text = it) {
                    // onClick(url)
                }

            }

            else -> null
        }

    @Composable
    fun renderStack(root: RockRoot) =
        when (root.element.name) {
            "column" -> Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                root.children?.map {
                    root.content?.get(it)?.let { it1 ->
                        base(it1)
                    }
                }
            }


            else -> Row {
                root.children?.map {
                    root.content?.get(it)?.let { it1 ->
                        base(it1)
                    }
                }
            }
        }

    @Composable
    fun base(r: RockRoot): Unit? {
        val result = when (r.element.type) {
            "layout" -> renderStack(r)
            else -> renderComponent(r.element.name, r.element.properties)
        }

        return result
    }

    @Composable
    fun render() = base(root)

}