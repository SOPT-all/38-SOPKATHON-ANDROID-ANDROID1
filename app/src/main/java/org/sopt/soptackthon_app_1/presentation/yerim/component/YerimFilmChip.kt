package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.designsystem.theme.gray_200

@Composable
fun YerimFilmChip(
    sec: Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .alpha(0.6f)
            .background(
                color = Color(0xFF191919),
                shape = CircleShape,
            )
    ){
        Row(
            modifier = Modifier.padding(
                start = 4.dp,
                end = 4.dp,
                top = 2.dp,
                bottom = 2.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(
                painter = painterResource(R.drawable.ic_film_16),
                contentDescription = null,
                tint = gray_200
            )

            Spacer(modifier = Modifier.width(1.dp))

            Text(
                text = "${sec}s",
                color = gray_200
            )
        }
    }
}

@Preview
@Composable
private fun YerimFilmChipPreview(){
    SopkathonTheme {
        YerimFilmChip(
            sec = 16
        )
    }
}