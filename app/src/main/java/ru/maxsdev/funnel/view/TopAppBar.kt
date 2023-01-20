package ru.maxsdev.funnel.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.maxsdev.theme.model.HeaderStyle
import ru.maxsdev.theme.views.Header
import ru.maxsdev.theme.views.Label


@Composable
fun TopAppBar(date: String, header: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp, start = 16.dp, end = 16.dp)) {
        Label(text = date)
        Header(text = header, style = HeaderStyle.H1)
    }
}

@[Composable Preview]
private fun TopAppBarPreview() {
    TopAppBar(date = "WEDNESDAY, 11 JUNUARY", header = "Good morning")
}
