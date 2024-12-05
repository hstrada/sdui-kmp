package server.driven.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("RockColumn")
data class RockColumn(
    private val content: @Composable () -> Unit,
    private val properties: Map<String, String>?
) : RockComponent() {
    @Composable
    override fun render() {
        return Column {
            content()
        }
    }
}