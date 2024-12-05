package server.driven.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("RockText")
data class RockText(
    private val text: String,
) : RockComponent() {

    @Composable
    override fun render() {
        return Text(text = text)
    }
}