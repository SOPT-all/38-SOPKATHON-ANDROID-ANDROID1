package org.sopt.soptackthon_app_1.prsentation.gabyu

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
fun GabyuRoute(
    navigateToYerim: () -> Unit
) {
    GabyuScreen(
        navigateToYerim = navigateToYerim,
    )
}

@Composable
fun GabyuScreen(
    modifier: Modifier = Modifier,
    navigateToYerim: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
    ) {
        Text(
            text = "Gabyu Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToYerim)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GabyuScreenPreview() {
    SopkathonTheme {
        GabyuScreen()
    }
}
