package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.designsystem.theme.gray_200
import org.sopt.soptackthon_app_1.core.designsystem.theme.white_

@Composable
fun YerimCardComponent(
    imgRes: Int,
    text: String,
    profileImg: Int,
    name: String,
    age: Int,
    sec: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Box(
            modifier = Modifier
                .width(328.dp)
                .height(170.dp)
                .background(
                    color = SopkathonTheme.colors.white,
                    shape = RoundedCornerShape(
                        topStart = 15.dp,
                        topEnd = 15.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                ),
            contentAlignment = Alignment.TopEnd
        ) {
            Image(
                painter = painterResource(imgRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 15.dp,
                            topEnd = 15.dp,
                            bottomStart = 0.dp,
                            bottomEnd = 0.dp
                        )
                    ),
                contentScale = ContentScale.Crop,

            )

            YerimFilmChip(
                sec = sec,
                modifier = Modifier.padding(
                    end = 19.dp,
                    top = 16.dp
                )
            )
        }

        Box(
            modifier = Modifier
                .width(328.dp)
                .height(114.dp)
                .background(
                    color = SopkathonTheme.colors.white,
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 15.dp,
                        bottomEnd = 15.dp
                    )
                )
                .border(
                    width = 1.dp,
                    color = gray_200,
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomStart = 15.dp,
                        bottomEnd = 15.dp
                    )
                )
                .padding(
                    top = 10.dp,
                    start = 17.dp,
                    end = 17.dp
                )
        ) {
            YerimCardTextComponent(
                text = text,
                profileImg = profileImg,
                name = name,
                age = age
            )
        }
    }
}

@Preview
@Composable
private fun YerimCardComponentPreview(){
    SopkathonTheme {
        YerimCardComponent(
            imgRes = R.drawable.img_ex,
            text = "안녕하세요 식물이 참 멋져요 반갑습니다",
            profileImg = R.drawable.profile,
            name = "강순자",
            age = 60,
            sec = 16
        )
    }
}