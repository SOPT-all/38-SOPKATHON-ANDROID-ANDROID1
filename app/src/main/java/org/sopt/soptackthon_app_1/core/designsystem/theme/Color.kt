package org.sopt.soptackthon_app_1.core.designsystem.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush

//primary Color
val primary_main = Color(0xFFFFE305)
val primary_sub = Color(0xFFFFFBD7)
val primary_sub_2 = Color(0xFF484848)
val primary_point = Color(0xFFFF922C)
val primary_point_2 = Color(0xFF8A4BFF)

//gray Color
val gray_50 = Color(0xFFF9F9F9)
val gray_100 = Color(0xFFF0F0F0)
val gray_200 = Color(0xFFE9E9E9)
val gray_300 = Color(0xFFDEDEDE)
val gray_400 = Color(0xFFC9C9C9)
val gray_500 = Color(0xFF999999)
val gray_700 = Color(0xFF4A5868)
val gray_900 = Color(0xFF212121)

//sub Color
val sub_red = Color(0xFFFF6224)
val sub_green = Color(0xFF42E79A)

//static Color
val white_ = Color(0xFFFCFCFC)
val black_ = Color(0xFF191919)

//gradient Color
val gradient_ = Brush.horizontalGradient(
    colors = listOf(Color(0xFFFFEE68), Color(0xFFFFFBD7))
)


@Immutable
data class SopkathonColor(

    val primaryMain: Color = primary_main,
    val primarySub: Color = primary_sub,
    val primarySub2: Color = primary_sub_2,
    val primaryPoint: Color = primary_point,
    val primaryPoint2: Color = primary_point_2,
    val gray50: Color = gray_50,
    val gray100: Color = gray_100,
    val gray200: Color = gray_200,
    val gray300: Color = gray_300,
    val gray400: Color = gray_400,
    val gray500: Color = gray_500,
    val gray700: Color = gray_700,
    val gray900: Color = gray_900,
    val subRed: Color = sub_red,
    val subGreen: Color = sub_green,
    val white: Color = white_,
    val black: Color = black_,
    val gradient: Brush = gradient_

)

val defaultSopkathonColor = SopkathonColor(

    primaryMain = primary_main,
    primarySub = primary_sub,
    primarySub2 = primary_sub_2,
    primaryPoint = primary_point,
    primaryPoint2 = primary_point_2,
    gray50 = gray_50,
    gray100 = gray_100,
    gray200 = gray_200,
    gray300 = gray_300,
    gray400 = gray_400,
    gray500 = gray_500,
    gray700 = gray_700,
    gray900 = gray_900,
    subRed = sub_red,
    subGreen = sub_green,
    white = white_,
    black = black_,
    gradient = gradient_

)


val LocalSopkathonColor = staticCompositionLocalOf { defaultSopkathonColor }
