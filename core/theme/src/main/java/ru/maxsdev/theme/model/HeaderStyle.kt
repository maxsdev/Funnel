package ru.maxsdev.theme.model

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import ru.maxsdev.theme.montserratFamily

enum class HeaderStyle constructor(
    val size: TextUnit,
    val fontFamily: FontFamily,
    val fontWeight: FontWeight
) {
    H1(size = 28.sp, fontFamily = montserratFamily, fontWeight = FontWeight.ExtraBold),
    H2(size = 16.sp, fontFamily = montserratFamily, fontWeight = FontWeight.Bold)
}
