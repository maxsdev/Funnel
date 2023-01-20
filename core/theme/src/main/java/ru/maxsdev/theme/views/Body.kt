package ru.maxsdev.theme.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.maxsdev.theme.TextPrimary
import ru.maxsdev.theme.notoSansFamily

@Composable
fun Body(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        color = TextPrimary,
        fontSize = 14.sp,
        fontFamily = notoSansFamily,
        fontWeight = FontWeight.Normal,
        modifier = modifier
    )
}

@[Composable Preview]
private fun BodyPreview() {
    Body(text = "Test body text")
}
