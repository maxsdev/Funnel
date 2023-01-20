package ru.maxsdev.theme.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.maxsdev.theme.TextPrimary
import ru.maxsdev.theme.model.HeaderStyle

@Composable
fun Header(text: String, modifier: Modifier = Modifier, style: HeaderStyle = HeaderStyle.H2) {
    Text(
        text = text,
        color = TextPrimary,
        fontSize = style.size,
        fontFamily = style.fontFamily,
        fontWeight = style.fontWeight,
        modifier = modifier
    )
}

@[Composable Preview]
private fun HeaderPreview() {
    Header(text = "Test header", style = HeaderStyle.H2)
}
