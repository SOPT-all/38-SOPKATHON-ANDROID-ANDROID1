package org.sopt.soptackthon_app_1.presentation.gabyu.component

import android.R.attr.onClick
import android.R.attr.text
import android.R.attr.width
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable


@Composable
fun BottomSheetContent(
    onClick:()->Unit={},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 45.dp, bottom = 17.dp)
    ) {
        Text(
            text = "어디로 공유할까요?",
            style = SopkathonTheme.typography.head.head6_bold,
            color = SopkathonTheme.colors.gray900,
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = "나의 기록을 원하는 곳에 공유해보세요!",
            style = SopkathonTheme.typography.head.head6_medium,
            color = SopkathonTheme.colors.gray500,
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = SopkathonTheme.colors.subGreen, shape = RoundedCornerShape(10.dp))
                .noRippleClickable(onClick),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.img_kakao_logo),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(13.dp))

            Column() {

                Text(
                    text = "카카오톡으로 보내기",
                    style = SopkathonTheme.typography.head.head6_medium,
                )


                Text(
                    text = "자녀 • 가족방 • 지인에게 공유해요",
                    style = SopkathonTheme.typography.body.body2
                )
            }
        }

        Spacer(modifier = Modifier.height(9.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = SopkathonTheme.colors.subGreen, shape = RoundedCornerShape(10.dp))
                .noRippleClickable(onClick),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_link_icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(13.dp))

            Column() {

                Text(
                    text = "링크 복사",
                    style = SopkathonTheme.typography.head.head6_medium,
                )

                Text(
                    text = "문자 • 다른 어플로 첨부할 수 있어요",
                    style = SopkathonTheme.typography.body.body2
                )
            }
        }

        Spacer(modifier = Modifier.height(9.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = SopkathonTheme.colors.subGreen, shape = RoundedCornerShape(10.dp))
                .noRippleClickable(onClick),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_send_icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(13.dp))

            Column() {

                Text(
                    text = "또래 게시판에 공유",
                    style = SopkathonTheme.typography.head.head6_medium,
                )

                Text(
                    text = "비슷한 또래 분들에게 나눠보아요",
                    style = SopkathonTheme.typography.body.body2
                )
            }
        }

    }


}
