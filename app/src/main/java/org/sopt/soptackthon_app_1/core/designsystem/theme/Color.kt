package org.sopt.soptackthon_app_1.core.designsystem.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class SopkathonColor(
    val black: Color,
    val white: Color
    // 요로코롬
)

val defaultSopkathonColor = SopkathonColor(
    black = Color(0xFF000000),
    white = Color(0xFFFFFFFF),
    // 요런식으로
)


val LocalSopkathonColor = staticCompositionLocalOf { defaultSopkathonColor }
