package org.sopt.soptackthon_app_1.presentation.gabyu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable
import org.sopt.soptackthon_app_1.presentation.gabyu.component.CalendarComponent


import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GabyuRoute(
    navigateToYerim: () -> Unit,
    navigateToCardDetail: (Long) -> Unit,
    viewModel: GabyuViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    GabyuScreen(
        uiState = uiState,
        navigateToYerim = navigateToYerim,
        onDayClick = navigateToCardDetail
    )

}

@Composable
fun GabyuScreen(
    uiState: GabyuUiState,
    onDayClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
    navigateToYerim: () -> Unit = {}
) {
    Column(modifier = modifier
        .fillMaxSize()
        .background(color = SopkathonTheme.colors.white)) {
        Text(
            text = "나의 노하우집",
            style = SopkathonTheme.typography.head.head3,
            modifier = Modifier
                .fillMaxWidth()
                .noRippleClickable(onClick = navigateToYerim)
                .padding(top = 47.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(17.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_prev_button),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterStart)
            )

            Text(
                text = "2026년 05월",
                style = SopkathonTheme.typography.head.head4,
                color = SopkathonTheme.colors.gray900,
                textAlign = TextAlign.Center
            )

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_next_button),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 33.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "일",
                style = SopkathonTheme.typography.head.head6_medium,
                color = SopkathonTheme.colors.subRed
            )
            Text(
                text = "월",
                style = SopkathonTheme.typography.head.head6_medium,
                color = SopkathonTheme.colors.gray400
            )
            Text(
                text = "화",
                style = SopkathonTheme.typography.head.head6_medium,
                color = SopkathonTheme.colors.gray400
            )
            Text(
                text = "수",
                style = SopkathonTheme.typography.head.head6_medium,
                color = SopkathonTheme.colors.gray400
            )
            Text(
                text = "목",
                style = SopkathonTheme.typography.head.head6_medium,
                color = SopkathonTheme.colors.gray400
            )
            Text(
                text = "금",
                style = SopkathonTheme.typography.head.head6_medium,
                color = SopkathonTheme.colors.gray400
            )
            Text(
                text = "토",
                style = SopkathonTheme.typography.head.head6_medium,
                color = SopkathonTheme.colors.subRed
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        when (uiState) {
            is GabyuUiState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = SopkathonTheme.colors.gray900
                    )
                }
            }

            is GabyuUiState.Success -> {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 16.dp)
                ) {
                    CalendarComponent(
                        gridDays = uiState.fullGridDays,
                        onDayClick = onDayClick
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        text = "기록된 노화우를 정리했어요!",
                        style = SopkathonTheme.typography.head.head6_bold,
                        color = SopkathonTheme.colors.gray900,
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Column(
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        // 이번달 노하우
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = SopkathonTheme.colors.subGreen,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(horizontal = 20.dp, vertical = 18.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "이번달 노하우",
                                style = SopkathonTheme.typography.head.head6_medium,
                                color = SopkathonTheme.colors.gray900
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "${uiState.info.recordCount}개",
                                    style = SopkathonTheme.typography.head.head6_medium,
                                    color = SopkathonTheme.colors.gray900
                                )
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.ic_next_button),
                                    contentDescription = null,
                                    tint = SopkathonTheme.colors.gray900,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }

                        // 공유된 노하우
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = SopkathonTheme.colors.subGreen,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .padding(horizontal = 20.dp, vertical = 18.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "공유된 노하우",
                                style = SopkathonTheme.typography.head.head6_medium,
                                color = SopkathonTheme.colors.gray900
                            )

                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Text(
                                    text = "${uiState.info.sharedCount}개",
                                    style = SopkathonTheme.typography.head.head6_medium,
                                    color = SopkathonTheme.colors.gray900
                                )
                                Icon(
                                    imageVector = ImageVector.vectorResource(R.drawable.ic_next_button),
                                    contentDescription = null,
                                    tint = SopkathonTheme.colors.gray900,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }
                    }
                }
            }


            is GabyuUiState.Error -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "데이터 수신 에러가 발생했습니다.\n${uiState.message}",
                        color = Color.Red,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GabyuScreenPreview() {
    SopkathonTheme {
        GabyuScreen(
            uiState = GabyuUiState.Loading,
            onDayClick = {}
        )
    }
}
