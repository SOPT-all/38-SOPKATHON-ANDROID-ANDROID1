package org.sopt.soptackthon_app_1.core.designsystem.theme

import android.R.attr.fontFamily
import android.R.id.bold
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import org.sopt.soptackthon_app_1.R


object SopkathonRegularFont  {
    val Regular= FontFamily(Font(R.font.noto_sans_kr_regular))
    val Medium = FontFamily(Font(R.font.noto_sans_kr_medium))
    val Bold = FontFamily(Font(R.font.noto_sans_kr_bold))
}

private fun SopkathonTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit = 1.5.em,
    letterSpacing: TextUnit
): TextStyle = TextStyle(
    fontFamily = fontFamily,
    fontSize = fontSize,
    lineHeight = lineHeight,
    letterSpacing = letterSpacing,
    lineHeightStyle = LineHeightStyle(
        alignment = LineHeightStyle.Alignment.Center,
        trim = LineHeightStyle.Trim.None
    )
)

sealed interface TypographyTokens {
    @Immutable
    data class Head(
        val head1: TextStyle,
        val head2: TextStyle,
        val head3: TextStyle,
        val head4: TextStyle,
        val head5: TextStyle,
        val head6_bold: TextStyle,
        val head6_medium: TextStyle,
        val head7_bold: TextStyle,
        val head7_medium: TextStyle,
        val head7_regular: TextStyle,
    )

    @Immutable
    data class Body(
        val body1: TextStyle,
        val body2: TextStyle,
    )

    @Immutable
    data class Caption(
        val caption: TextStyle
    )
}

@Immutable
data class SopkathonTypography(
    val head: TypographyTokens.Head,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption
)

val defaultSopkathonTypography = SopkathonTypography(
    head = TypographyTokens.Head(
        head1 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Bold,
            fontSize = 24.sp,
            letterSpacing = -0.02.em
        ),

        head2 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Bold,
            fontSize = 22.sp,
            letterSpacing = -0.02.em
        ),

        head3 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Bold,
            fontSize = 20.sp,
            letterSpacing = -0.02.em
        ),

        head4 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Bold,
            fontSize = 18.sp,
            letterSpacing = -0.02.em
        ),

        head5 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Medium,
            fontSize = 18.sp,
            letterSpacing = -0.02.em
        ),

        head6_bold = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Bold,
            fontSize = 16.sp,
            letterSpacing = -0.02.em
        ),

        head6_medium = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Medium,
            fontSize = 16.sp,
            letterSpacing = -0.02.em
        ),

        head7_bold = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Bold,
            fontSize = 14.sp,
            letterSpacing = -0.02.em
        ),

        head7_medium = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Medium,
            fontSize = 14.sp,
            letterSpacing = -0.02.em
        ),

        head7_regular = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Regular,
            fontSize = 14.sp,
            letterSpacing = -0.02.em
        ),
    ),

    body = TypographyTokens.Body(
        body1 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Bold,
            fontSize = 12.sp,
            letterSpacing = -0.02.em
        ),

        body2 = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Regular,
            fontSize = 12.sp,
            letterSpacing = -0.02.em
        ),
    ),

    caption = TypographyTokens.Caption(
        caption = SopkathonTextStyle(
            fontFamily = SopkathonRegularFont.Regular,
            fontSize = 11.sp,
            letterSpacing = -0.02.em
        )
    )
)

val LocalSopkathonTypography = staticCompositionLocalOf { defaultSopkathonTypography }
