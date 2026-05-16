package org.sopt.soptackthon_app_1.presentation.yerim

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
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
    navigateToYubin: () -> Unit = {},
    viewModel: YerimViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getHomeRecords()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    ) {

        YerimTopBar()

        Spacer(modifier = Modifier.height(36.dp))

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

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            items(uiState.records) { record ->

                YerimCardComponent(
                    recordId = record.recordId,
                    photoUrl = record.photoUrl,
                    profileImageUrl = record.author.profileImageUrl,
                    text = record.title,
                    name = record.author.name,
                    age = record.author.age,
                    sec = record.voiceDurationSeconds ?: 0,
                    createdAt = record.createdAt
                )

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun YerimScreenPreview() {
    SopkathonTheme {
        YerimScreen()
    }
}