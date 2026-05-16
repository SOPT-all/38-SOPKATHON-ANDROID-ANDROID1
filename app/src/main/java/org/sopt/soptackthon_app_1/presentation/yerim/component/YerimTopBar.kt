package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(
//                start = 18.dp,
//                end = 18.dp,
                top = 47.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Image(
            painter = painterResource(id = R.drawable.img_home_logo),
            contentDescription = null
        )

        Spacer(modifier = Modifier.padding(end = 110.dp))

        Text(
            text = "노화우",
            style = SopkathonTheme.typography.head.head3
        )

        Spacer(modifier = Modifier.padding(end = 150.dp))

        Icon(
            painter = painterResource(R.drawable.ic_notification_24),
            contentDescription = null,
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