package ru.maxsdev.theme.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import ru.maxsdev.theme.TextSecondary
import ru.maxsdev.theme.notoSansFamily

@Composable
fun Label(text: String, modifier: Modifier = Modifier, maxLines: Int = Int.MAX_VALUE) {
    Text(
        text = text,
        color = TextSecondary,
        fontSize = 12.sp,
        fontFamily = notoSansFamily,
        fontWeight = FontWeight.Normal,
        modifier = modifier,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis
    )
}

@[Composable Preview]
private fun LabelPreview() {
    Label(text = "Test label preview")
}
