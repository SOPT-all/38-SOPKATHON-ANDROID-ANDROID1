package org.sopt.soptackthon_app_1.presentation.gabyu.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable
import org.sopt.soptackthon_app_1.presentation.yerim.component.YerimButtonComponent

enum class ShareType {
    KAKAO, LINK, BOARD
}

@Composable
fun BottomSheetContent(
    selectedType: ShareType?,
    onTypeSelected: (ShareType) -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SopkathonTheme.colors.white)
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

        // 카카오톡
        val isKakaoSelected = selectedType == ShareType.KAKAO
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(color = SopkathonTheme.colors.subGreenGray)
                .border(
                    width = if (isKakaoSelected) 1.dp else 0.dp,
                    color = if (isKakaoSelected) SopkathonTheme.colors.subGreen else Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
                .noRippleClickable { onTypeSelected(ShareType.KAKAO) }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.img_splash_logo), // Placeholder
                contentDescription = null,
                modifier = Modifier.size(45.dp),
            )
            Spacer(modifier = Modifier.width(13.dp))
            Column {
                Text(
                    text =  "카카오톡으로 보내기",
                    style = SopkathonTheme.typography.head.head6_medium,
                    color = SopkathonTheme.colors.gray900
                )
                Text(
                    text = "자녀 • 가족방 • 지인에게 공유해요",
                    style = SopkathonTheme.typography.body.body2,
                    color = SopkathonTheme.colors.gray500
                )
            }
        }

        Spacer(modifier = Modifier.height(9.dp))

        // 링크 복사
        val isLinkSelected = selectedType == ShareType.LINK
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(color = SopkathonTheme.colors.subGreenGray)
                .border(
                    width = if (isLinkSelected) 1.dp else 0.dp,
                    color = if (isLinkSelected) SopkathonTheme.colors.subGreen else Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
                .noRippleClickable { onTypeSelected(ShareType.LINK) }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_link_icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(13.dp))
            Column {
                Text(
                    text = "링크 복사",
                    style = SopkathonTheme.typography.head.head6_medium,
                    color = SopkathonTheme.colors.gray900
                )
                Text(
                    text = "문자 • 다른 어플로 첨부할 수 있어요",
                    style = SopkathonTheme.typography.body.body2,
                    color = SopkathonTheme.colors.gray500
                )
            }
        }

        Spacer(modifier = Modifier.height(9.dp))

        // 또래 게시판
        val isBoardSelected = selectedType == ShareType.BOARD
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(color = SopkathonTheme.colors.subGreenGray)
                .border(
                    width = if (isBoardSelected) 1.dp else 0.dp,
                    color = if (isBoardSelected) SopkathonTheme.colors.subGreen else Color.Transparent,
                    shape = RoundedCornerShape(10.dp)
                )
                .noRippleClickable { onTypeSelected(ShareType.BOARD) }
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_send_icon),
                contentDescription = null,
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(13.dp))
            Column {
                Text(
                    text = "또래 게시판에 공유",
                    style = SopkathonTheme.typography.head.head6_medium,
                    color = SopkathonTheme.colors.gray900
                )
                Text(
                    text = "비슷한 또래 분들에게 나눠보아요",
                    style = SopkathonTheme.typography.body.body2,
                    color = SopkathonTheme.colors.gray500
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        YerimButtonComponent(
            onClick = onShareClick,
            text = "공유하기",
            backgroundColor = SopkathonTheme.colors.gray900,
            textColor = SopkathonTheme.colors.white,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
