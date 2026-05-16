package org.sopt.soptackthon_app_1.presentation.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.sopt.soptackthon_app_1.core.navigation.Yubin2
import org.sopt.soptackthon_app_1.presentation.main.component.MainBottomBar
import org.sopt.soptackthon_app_1.presentation.main.component.MainTab

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentTab = when {
        currentDestination?.hasRoute<Yubin2>() == true -> MainTab.GABYU
        else -> MainTab.find { route ->
            currentDestination?.hierarchy?.any { it.hasRoute(route::class) } == true
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),
        bottomBar = {
            MainBottomBar(
                tabs = MainTab.entries,
                currentTab = currentTab,
                onTabSelected = { tab ->
                    navController.navigateMainTab(tab.route)
                }
            )
        }
    ) { innerPadding ->
        MainNavHost(
            navController = navController,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
        )
    }
}
