package org.sopt.soptackthon_app_1.presentation.yerim.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import org.sopt.soptackthon_app_1.core.designsystem.theme.gray_500

@Composable
fun YerimReactionComponent(
    icon: Int,
    reactionCount: String,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = gray_500
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = reactionCount,
            color = gray_500
        )
    }
}

@Preview
@Composable
private fun YerimReactionComponentPreview(){
    SopkathonTheme{
        YerimReactionComponent(
            icon = R.drawable.ic_comment_22,
            reactionCount = "14"
        )
    }
}