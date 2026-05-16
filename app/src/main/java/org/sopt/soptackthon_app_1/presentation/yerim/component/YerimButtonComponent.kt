package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable // 1. 노리플 클릭 유틸 임포트

@Composable
fun YerimButtonComponent(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = "저장하기",
    backgroundColor: Color = SopkathonTheme.colors.gray700,
    textColor: Color = SopkathonTheme.colors.white
) {
    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(size = 12.dp)
            )
            .noRippleClickable(onClick = onClick)
           .padding(horizontal = 52.dp, vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = textColor,
            style = SopkathonTheme.typography.head.head6_medium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun YerimButtonComponentPreview() {
    SopkathonTheme {
        Column(modifier = Modifier.padding(20.dp)) {
            YerimButtonComponent(
                onClick = { println("저장하기 클릭!") }
            )

            Spacer(modifier = Modifier.height(10.dp))

            YerimButtonComponent(
                onClick = { println("공유하기 클릭!") },
                text = "공유하기",
                backgroundColor = SopkathonTheme.colors.gray200,
                textColor = SopkathonTheme.colors.gray700,
                modifier = Modifier.height(52.dp) // height만 고정하거나 width를 외부에서 제어
            )
        }
    }
}
