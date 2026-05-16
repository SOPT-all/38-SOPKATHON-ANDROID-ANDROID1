package org.sopt.soptackthon_app_1.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

object SopkathonTheme {
    val colors: SopkathonColor
        @Composable
        @ReadOnlyComposable
        get() = LocalSopkathonColor.current

    val typography: SopkathonTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalSopkathonTypography.current
}

@Composable
fun ProvideSopkathonColorsAndTypography(
    colors: SopkathonColor,
    typography: SopkathonTypography,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalSopkathonColor provides colors,
        LocalSopkathonTypography provides typography,
        content = content
    )
}

@Composable
fun SopkathonTheme(
    content: @Composable () -> Unit,
) {
    val colorScheme = lightColorScheme(
        primary = primary_main,
        secondary = primary_sub,
        background = white_,
        surface = white_,
        onPrimary = black_,
        onSecondary = black_,
        onBackground = black_,
        onSurface = black_,
    )

    ProvideSopkathonColorsAndTypography(
        colors = defaultSopkathonColor,
        typography = defaultSopkathonTypography,
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view).isAppearanceLightStatusBars = true
                }
            }
        }
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}
