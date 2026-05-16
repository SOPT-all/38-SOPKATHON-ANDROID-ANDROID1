package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme

@Composable
fun YerimTopBar(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
    ) {

        Image(
            painter = painterResource(id = R.drawable.img_home_logo),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterStart)
        )

        Text(
            text = "노화우",
            style = SopkathonTheme.typography.head.head3,
            modifier = Modifier.align(Alignment.Center)
        )

        Icon(
            painter = painterResource(R.drawable.ic_notification_24),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun YerimTopBarPreview(){
    SopkathonTheme{
        YerimTopBar()
    }
}