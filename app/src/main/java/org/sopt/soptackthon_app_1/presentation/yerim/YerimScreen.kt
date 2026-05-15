package org.sopt.soptackthon_app_1.presentation.yerim

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable


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
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
    ) {
        Text(
            text = "Yerim Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToYubin)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun YerimScreenPreview() {
    SopkathonTheme {
        YerimScreen()
    }
}
