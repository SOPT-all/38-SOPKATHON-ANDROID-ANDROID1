package org.sopt.soptackthon_app_1.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.soptackthon_app_1.presentation.gabyu.GabyuRoute
import org.sopt.soptackthon_app_1.presentation.yerim.YerimRoute
import org.sopt.soptackthon_app_1.presentation.yubin.YubinRoute
import org.sopt.soptackthon_app_1.presentation.yubin2.Yubin2Route

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = "gabyu"
        ) {
            composable(route = "gabyu") {
                GabyuRoute(
                    navigateToYerim = { navController.navigateToYerim() }
                )
            }

            composable(route = "yerim") {
                YerimRoute(
                    navigateToYubin = { navController.navigateToYubin() }
                )
            }

            composable(route = "yubin") {
                YubinRoute(
                    navigateToYubin2 = { navController.navigateToYubin2() }
                )
            }

            composable(route = "yubin2") {
                Yubin2Route(
                    navigateToGabyu = { navController.navigateToGabyu() },
                )
            }
        }
    }
}
