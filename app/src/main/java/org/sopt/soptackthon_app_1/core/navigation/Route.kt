package org.sopt.soptackthon_app_1.core.navigation

import kotlinx.serialization.Serializable

interface Route

@Serializable
data object Splash : Route

@Serializable
data object Main : Route
