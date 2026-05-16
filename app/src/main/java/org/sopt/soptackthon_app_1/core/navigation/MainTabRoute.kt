package org.sopt.soptackthon_app_1.core.navigation

import kotlinx.serialization.Serializable

interface MainTabRoute : Route

@Serializable
data object Yerim : MainTabRoute

@Serializable
data object Yubin : MainTabRoute

@Serializable
data object Gabyu : MainTabRoute

@Serializable
data object Yubin2 : Route
