package com.apolloagriculture.android.takehomeassignment.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    onPrimary = Color.Gray,
    secondary = SecondaryColor,
    onSecondary = Color.Gray,
    surface = Black,
    onSurface = White,
    background = Black,
    onBackground = White
)

private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    onPrimary = Color.Gray,
    secondary = SecondaryColor,
    onSecondary = Color.Gray,
    surface = White,
    onSurface = Black,
    background = Black,
    onBackground = White
)

@Composable
fun ApolloAndroidTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
