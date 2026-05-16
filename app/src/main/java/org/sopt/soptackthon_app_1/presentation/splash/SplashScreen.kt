package org.sopt.soptackthon_app_1.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme

@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit,
    modifier: Modifier = Modifier
) {
    LaunchedEffect(Unit) {
        delay(2000L)
        onSplashFinished()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = SopkathonTheme.colors.primarySub),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ){
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.img_splash_logo),
            contentDescription = null
        )
    }

}

@Preview
@Composable
private fun SplashScreenPreview() {
    SopkathonTheme {
        SplashScreen(onSplashFinished = {})
    }
}
