package org.sopt.soptackthon_app_1.prsentation.yubin2

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
fun Yubin2Route(
    navigateToGabyu: () -> Unit
) {
    Yubin2Screen(
        navigateToGabyu = navigateToGabyu,
    )
}


@Composable
fun Yubin2Screen(
    modifier: Modifier = Modifier,
    navigateToGabyu: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                color = SopkathonTheme.colors.white
            )
    ) {
        Text(
            text = "Yubin2 Screen",
            modifier = Modifier
                .noRippleClickable(onClick = navigateToGabyu)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun Yubin2ScreenPreview() {
    SopkathonTheme {
        Yubin2Screen()
    }
}
