package server.driven.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import kotlinx.serialization.EncodeDefault
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("RockColumn")
data class RockColumn(
    private val content: @Composable () -> Unit,
) : RockComponent() {
    @Composable
    override fun render() {
        return Column {
            content()
        }
    }
}