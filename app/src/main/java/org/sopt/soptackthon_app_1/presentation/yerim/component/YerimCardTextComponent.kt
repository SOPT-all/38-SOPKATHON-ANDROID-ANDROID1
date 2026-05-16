package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.component.UrlImage
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.designsystem.theme.black_
import org.sopt.soptackthon_app_1.core.designsystem.theme.gray_900

@Composable
fun YerimCardTextComponent(
    text: String,
    profileImageUrl: String,
    name: String,
    age: Int,
    createdAt: String,
    modifier: Modifier = Modifier,
    likes: Int = 12,
    comments: Int = 30
){
    Column(
        modifier = modifier.fillMaxWidth()
    ){
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ){
            UrlImage(
                url = "https://sopkathon.o-r.kr$profileImageUrl",
                placeholderDrawable = R.drawable.profile,
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(11.dp))

            Text(
                text = "${name}님",
                style = SopkathonTheme.typography.head.head7_regular,
                color = black_
            )

            Spacer(modifier = Modifier.width(5.dp))

            Icon(
                painter = painterResource(R.drawable.ic_dot_divider),
                contentDescription = null,
                tint = Color.Unspecified
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = "${age}세",
                style = SopkathonTheme.typography.head.head7_regular,
                color = black_
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = text,
            style = SopkathonTheme.typography.head.head6_bold,
            color = gray_900
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.align(Alignment.End)
        ){
            YerimReactionComponent(
                icon = R.drawable.ic_heart_22,
                reactionCount = likes.toString()
            )

            Spacer(modifier = Modifier.width(8.dp))

            YerimReactionComponent(
                icon = R.drawable.ic_comment_22,
                reactionCount = comments.toString()
            )
        }
    }
}