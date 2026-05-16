package org.sopt.soptackthon_app_1.presentation.main.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.util.noRippleClickable

@Composable
fun MainBottomBar(
    tabs: List<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(color = SopkathonTheme.colors.black)
            .navigationBarsPadding(),
    ) {
        Box(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = SopkathonTheme.colors.black),
        )

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 50.dp,
                        top = 8.dp,
                        end = 50.dp,
                        bottom = 8.dp,
                    ),
            horizontalArrangement = Arrangement.SpaceAround,
        ) {
            tabs.forEach { tab ->
                val selectedIcon =
                    if (tab == currentTab) tab.selectedIconRes else tab.unselectedIconRes
                val selectedColor =
                    if (tab == currentTab) Color.Unspecified else Color.Unspecified

                MainNavigationBarItem(
                    tab = tab,
                    onClick = { onTabSelected(tab) },
                    selectedIcon = selectedIcon,
                    selectedColor = selectedColor,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun MainNavigationBarItem(
    tab: MainTab,
    onClick: () -> Unit,
    @DrawableRes selectedIcon: Int,
    selectedColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .semantics(mergeDescendants = true) { role = Role.Tab }
                .noRippleClickable(onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 4.dp,
            alignment = Alignment.CenterVertically
        ),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(selectedIcon),
            contentDescription = stringResource(tab.titleRes),
            tint = Color.Unspecified,
        )

        Text(
            text = stringResource(tab.titleRes),
            color = SopkathonTheme.colors.white,
            style = SopkathonTheme.typography.caption.caption,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MainBottomBarPreview() {
    SopkathonTheme {
        var selectedTab by androidx.compose.runtime.remember {
            androidx.compose.runtime.mutableStateOf(MainTab.YERIM)
        }

        MainBottomBar(
            tabs = MainTab.entries,
            currentTab = selectedTab,
            onTabSelected = { clickedTab ->
                selectedTab = clickedTab
            },
        )
    }
}
