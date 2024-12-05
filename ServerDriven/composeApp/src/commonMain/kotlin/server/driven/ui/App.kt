package server.driven.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import server.driven.ui.components.RockColumn
import server.driven.ui.components.RockText

@Composable
fun App(
    content: @Composable () -> Unit
) {

    MaterialTheme {
        content()
    }
}

@Preview
@Composable
fun AppPreview() {
    App(
        content = {}
    )
}
