package com.example.tsboard.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// 다크 테마 색상 팔레트
private val DarkColorScheme = darkColorScheme(
    primary = WhiteText,
    secondary = DarkGrey,
    tertiary = MainBlue,
    background = BlackBackground,
    surface = DarkGrey,
    onPrimary = WhiteText,
    onSecondary = WhiteText,
    onTertiary = BlackBackground,
    onBackground = WhiteText,
    onSurface = WhiteText
)

// 라이트 테마 색상 팔레트
private val LightColorScheme = lightColorScheme(
    primary = DarkText,
    secondary = LightBlue,
    tertiary = MainBlue,
    background = LightGrey,
    surface = LightGrey,
    onPrimary = WhiteText,
    onSecondary = DarkText,
    onTertiary = DarkText,
    onBackground = DarkText,
    onSurface = DarkText
)

@Composable
fun TsboardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}