package org.sopt.soptackthon_app_1.presentation.yubin

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
fun YubinRoute(
    navigateToYubin2: () -> Unit
) {
    YubinScreen(
        navigateToYubin2 = navigateToYubin2,
    )
}


@Composable
fun YubinScreen(
    modifier: Modifier = Modifier,
    navigateToYubin2: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
    ) {
        Text(
            text = "Yubin Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToYubin2)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun YubinScreenPreview() {
    SopkathonTheme {
        YubinScreen()
    }
}
