package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.component.UrlImage
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.designsystem.theme.gray_200

@Composable
fun YerimCardComponent(
    recordId: Long,
    photoUrl: String?,
    profileImageUrl: String,
    text: String,
    name: String,
    age: Int,
    sec: Int,
    createdAt: String,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 18.dp,
                        topEnd = 18.dp
                    )
                ),
            contentAlignment = Alignment.TopEnd
        ) {

            UrlImage(
                url = "https://sopkathon.o-r.kr$photoUrl",
                placeholderDrawable = R.drawable.img_ex,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
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
                .fillMaxWidth()
                .background(
                    color = SopkathonTheme.colors.white,
                    shape = RoundedCornerShape(
                        bottomStart = 15.dp,
                        bottomEnd = 15.dp
                    )
                )
                .border(
                    width = 1.dp,
                    color = gray_200,
                    shape = RoundedCornerShape(
                        bottomStart = 15.dp,
                        bottomEnd = 15.dp
                    )
                )
                .padding(
                    top = 10.dp,
                    start = 17.dp,
                    end = 17.dp,
                    bottom = 14.dp
                )
        ) {

            YerimCardTextComponent(
                text = text,
                profileImageUrl = profileImageUrl,
                name = name,
                age = age,
                createdAt = createdAt
            )
        }
    }
}