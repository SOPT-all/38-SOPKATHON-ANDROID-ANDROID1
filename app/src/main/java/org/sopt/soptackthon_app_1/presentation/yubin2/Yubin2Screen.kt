package org.sopt.soptackthon_app_1.presentation.yubin2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable

@Composable
fun Yubin2Route(
    recordId: Long,
    navigateToGabyu: () -> Unit,
    viewModel: Yubin2ViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(recordId) {
        viewModel.getRecordDetail(recordId)
    }

    Yubin2Screen(
        uiState = uiState,
        onBackClick = navigateToGabyu
    )
}

@Composable
fun Yubin2Screen(
    uiState: Yubin2UiState,
    onBackClick: () -> Unit = {}
) {
    val record = uiState.record

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SopkathonTheme.colors.white)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 12.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .noRippleClickable(onBackClick)
                    .size(24.dp),
                tint = Color.Unspecified
            )
            Text(
                text = uiState.formattedDate,
                style = SopkathonTheme.typography.head.head3,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "제목",
                style = SopkathonTheme.typography.head.head6_bold,
            )
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(SopkathonTheme.colors.gray100)
                    .padding(horizontal = 13.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = record?.title ?: "",
                    style = SopkathonTheme.typography.head.head6_medium,
                    color = SopkathonTheme.colors.black
                )
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_pencil),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.Unspecified
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(SopkathonTheme.colors.subGreenGray)
                        .padding(all = 5.dp)
                ) {
                    Text(
                        text = uiState.formattedTime,
                        style = SopkathonTheme.typography.head.head7_medium,
                        color = SopkathonTheme.colors.black,
                    )
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(SopkathonTheme.colors.gray200)
                        .padding(horizontal = 13.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "서울 노원구",
                        style = SopkathonTheme.typography.head.head7_medium,
                        color = SopkathonTheme.colors.black
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(15.dp))
                    .background(SopkathonTheme.colors.gray100)
            ) {
                AsyncImage(
                    model = record?.photoUrl,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.ic_launcher_background)
                )
            }

            Spacer(modifier = Modifier.height(17.dp))

            Text(
                text = "음성 기록",
                style = SopkathonTheme.typography.head.head6_bold,
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(SopkathonTheme.colors.subGreenGray)
                    .padding(horizontal = 13.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_play),
                    contentDescription = null,
                    modifier = Modifier.size(37.dp),
                    tint = Color.Unspecified,
                )

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_prograss),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )

                Text(
                    text = "0.48",
                    style = SopkathonTheme.typography.head.head6_bold,
                    color = SopkathonTheme.colors.gray700
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(SopkathonTheme.colors.gray100)
                    .padding(vertical = 18.dp, horizontal = 14.dp)
            ) {
                Column {
                    Text(
                        text = "음성 기록 옮김",
                        style = SopkathonTheme.typography.head.head7_regular,
                        color = SopkathonTheme.colors.gray500
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "오늘 상추 모종 다섯 개 심었어, 아침에만 물을 줘야해.\n저녁에 주면 잎이 무거워져서 안 좋더라고\n한 달이면 따 먹을 수 있을거야",
                        style = SopkathonTheme.typography.head.head7_regular,
                        color = SopkathonTheme.colors.black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Yubin2ScreenPreview() {
    SopkathonTheme {
        Yubin2Screen(uiState = Yubin2UiState())
    }
}
