package com.example.grafikuz.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColors = darkColorScheme(
    primary = PrimaryBlue,
    secondary = SecondaryBlue,
    background = BackgroundDark,
    surface = BackgroundLight,
    onPrimary = TextWhite,
    onBackground = TextWhite,
    onSurface = TextLight
)

@Composable
fun GrafikUzTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkColors,
        typography = Typography,
        content = content
    )
}