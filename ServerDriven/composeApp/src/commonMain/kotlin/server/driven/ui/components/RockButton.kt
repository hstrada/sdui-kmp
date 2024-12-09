package server.driven.ui.components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun RockButton(
    text: String,
    onPress: () -> Unit
) = Button(
    onClick = onPress
) {
    Text(text = text)
}
