package server.driven.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

fun RockColumn(
    content: @Composable () -> Unit
) {
    @Composable
    fun render() {
        return Column {
            content()
        }
    }
}