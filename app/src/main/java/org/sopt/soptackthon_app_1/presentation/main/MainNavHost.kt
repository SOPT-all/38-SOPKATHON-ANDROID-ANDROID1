package org.sopt.soptackthon_app_1.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.soptackthon_app_1.core.navigation.Gabyu
import org.sopt.soptackthon_app_1.core.navigation.Yerim
import org.sopt.soptackthon_app_1.core.navigation.Yubin
import org.sopt.soptackthon_app_1.core.navigation.Yubin2
import org.sopt.soptackthon_app_1.presentation.gabyu.GabyuRoute
import org.sopt.soptackthon_app_1.presentation.yerim.YerimRoute
import org.sopt.soptackthon_app_1.presentation.yubin.YubinRoute
import org.sopt.soptackthon_app_1.presentation.yubin2.Yubin2Route
import androidx.navigation.toRoute

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
            startDestination = Yerim
        ) {
            composable<Yerim> {
                YerimRoute(
                    navigateToYubin = { navController.navigateToYubin() }
                )
            }

            composable<Yubin> {
                YubinRoute(
                    navigateToGabyu = { navController.navigateToGabyu() }
                )
            }

            composable<Yubin2> { backStackEntry ->
                val route: Yubin2 = backStackEntry.toRoute()
                Yubin2Route(
                    recordId = route.recordId,
                    navigateToGabyu = { navController.navigateToGabyu() },
                )
            }

            composable<Gabyu> {
                GabyuRoute(
                    navigateToYerim = { navController.navigateToYerim() }
                )
            }
        }
    }
}
