package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme

@Composable
fun YerimButtonComponent(
    modifier: Modifier = Modifier,
    text: String = "저장하기",
    backgroundColor: Color = SopkathonTheme.colors.gray700,
    textColor: Color = SopkathonTheme.colors.white
){
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .width(162.dp)
            .height(52.dp),
        contentAlignment = Alignment.Center

    ){
        Text(
            text = text,
            color = textColor,
            style = SopkathonTheme.typography.head.head6_medium
        )
    }
}

@Preview
@Composable
private fun YerimButtonComponentPreview(){
    SopkathonTheme{

        Column() {
            YerimButtonComponent()

            Spacer(modifier = Modifier.height(10.dp))

            YerimButtonComponent(
                text = "공유하기",
                backgroundColor = SopkathonTheme.colors.gray200,
                textColor = SopkathonTheme.colors.gray700
            )
        }
    }
}