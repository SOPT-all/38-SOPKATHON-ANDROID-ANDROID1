package org.sopt.soptackthon_app_1.presentation.yerim

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.R
import androidx.compose.foundation.lazy.items
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.designsystem.theme.gray_500
import org.sopt.soptackthon_app_1.core.designsystem.theme.gray_900
import org.sopt.soptackthon_app_1.presentation.yerim.component.YerimCardComponent
import org.sopt.soptackthon_app_1.presentation.yerim.component.YerimTopBar


@Composable
fun YerimRoute(
    navigateToYubin: () -> Unit
) {
    YerimScreen(
        navigateToYubin = navigateToYubin,
    )
}

@Composable
fun YerimScreen(
    modifier: Modifier = Modifier,
    navigateToYubin: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
            .padding(
                start = 18.dp,
                end = 18.dp
            )
    ) {

        YerimTopBar()

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "오늘의 노화우",
            style = SopkathonTheme.typography.head.head6_bold,
            color = gray_900
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "또래분들의 일상 속 작은 노하우를 나눠보세요!",
            style = SopkathonTheme.typography.head.head7_medium,
            color = gray_500
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(dummyCardList) { card ->
                YerimCardComponent(
                    imgRes = card.imgRes,
                    text = card.text,
                    profileImg = card.profileImg,
                    name = card.name,
                    age = card.age,
                    sec = card.sec
                )

                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}

data class YerimCardData(
    val imgRes: Int,
    val text: String,
    val profileImg: Int,
    val name: String,
    val age: Int,
    val sec: Int
)

private val dummyCardList = listOf(
    YerimCardData(
        imgRes = R.drawable.img_ex,
        text = "오늘은 화분에 물 주는 날이에요 ",
        profileImg = R.drawable.profile,
        name = "강금순",
        age = 80,
        sec = 30
    ),
    YerimCardData(
        imgRes = R.drawable.img_ex,
        text = "아침 산책 20분이 하루를 개운하게 해줘요",
        profileImg = R.drawable.profile,
        name = "박영자",
        age = 76,
        sec = 24
    ),
    YerimCardData(
        imgRes = R.drawable.img_ex,
        text = "손주랑 같이 사진 찍으러 다녀왔어요 😊",
        profileImg = R.drawable.profile,
        name = "이순희",
        age = 72,
        sec = 15,
    )
)
@Preview(showBackground = true)
@Composable
private fun YerimScreenPreview() {
    SopkathonTheme {
        YerimScreen()
    }
}
