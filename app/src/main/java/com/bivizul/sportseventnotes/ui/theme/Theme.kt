package com.bivizul.sportseventnotes.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = d333,
    secondary = d444,
    error = d111,
    background = d222
)

private val LightColorPalette = lightColors(
    primary = l333,
    secondary = l444,
    error = l111,
    background = l222
)

@Composable
fun SportsEventNotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val systemUiController = rememberSystemUiController()
    if (darkTheme) {
        systemUiController.setSystemBarsColor(
            color = DarkColorPalette.background
        )
    } else {
        systemUiController.setSystemBarsColor(
            color = LightColorPalette.background
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}