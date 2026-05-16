package org.sopt.soptackthon_app_1.presentation.gabyu.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.core.designsystem.component.UrlImage
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable
import org.sopt.soptackthon_app_1.presentation.gabyu.CalendarDayUiModel

@Composable
fun CalendarComponent(
    gridDays: List<CalendarDayUiModel>,
    onDayClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(7),
        modifier = modifier.padding(horizontal = 16.dp),
        userScrollEnabled = false
    ) {
        items(gridDays) { dayModel ->
            CalendarDayItem(
                dayModel = dayModel,
                onClick = { dayModel.recordId?.let { onDayClick(it) } }
            )
        }
    }
}

@Composable
fun CalendarDayItem(
    dayModel: CalendarDayUiModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(2.dp)
            .border(
                width = 1.dp,
                color = SopkathonTheme.colors.gray100,
                shape = RoundedCornerShape(4.dp)
            )
            .clip(RoundedCornerShape(4.dp))
            .background(SopkathonTheme.colors.white)
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        if (dayModel.day != null) {
            // 배경 이미지 표시
            if (dayModel.thumbnailUrl != null) {
                UrlImage(
                    url = dayModel.thumbnailUrl,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            
            // 날짜 숫자 표시
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(4.dp)
                    .then(
                        if (dayModel.thumbnailUrl != null) {
                            Modifier
                                .background(
                                    color = Color.Black.copy(alpha = 0.3f),
                                    shape = CircleShape
                                )
                                .size(18.dp)
                        } else Modifier
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = dayModel.day.toString(),
                    style = SopkathonTheme.typography.caption.caption,
                    color = if (dayModel.thumbnailUrl != null) Color.White else SopkathonTheme.colors.gray400,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
