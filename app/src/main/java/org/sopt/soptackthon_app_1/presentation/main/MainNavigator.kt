package org.sopt.soptackthon_app_1.presentation.main

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptionsBuilder
import org.sopt.soptackthon_app_1.core.navigation.Gabyu
import org.sopt.soptackthon_app_1.core.navigation.Route
import org.sopt.soptackthon_app_1.core.navigation.Yerim
import org.sopt.soptackthon_app_1.core.navigation.Yubin
import org.sopt.soptackthon_app_1.core.navigation.Yubin2

fun NavController.navigateToYubin(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(Yubin, navOptions)
}

fun NavController.navigateToYerim(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(Yerim, navOptions)
}

fun NavController.navigateToGabyu(navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(Gabyu, navOptions)
}

fun NavController.navigateToYubin2(recordId: Long, navOptions: NavOptionsBuilder.() -> Unit = {}) {
    navigate(Yubin2(recordId), navOptions)
}

fun NavController.navigateMainTab(route: Route) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
