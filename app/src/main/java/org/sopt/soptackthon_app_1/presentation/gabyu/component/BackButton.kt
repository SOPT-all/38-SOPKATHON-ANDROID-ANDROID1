package org.sopt.soptackthon_app_1.presentation.gabyu.component

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import org.sopt.soptackthon_app_1.R
import org.sopt.soptackthon_app_1.core.util.noRippleClickable

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){

    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_backbutton),
        contentDescription = null,
        modifier = modifier
            .noRippleClickable(onClick)
    )

}