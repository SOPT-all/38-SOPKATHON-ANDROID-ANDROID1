package org.sopt.soptackthon_app_1.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.sopt.soptackthon_app_1.core.designsystem.theme.SopkathonTheme
import org.sopt.soptackthon_app_1.core.navigation.Main
import org.sopt.soptackthon_app_1.core.navigation.Splash
import org.sopt.soptackthon_app_1.presentation.splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val rootNavController = rememberNavController()
            SopkathonTheme {
                NavHost(
                    navController = rootNavController,
                    startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(
                            onSplashFinished = {
                                rootNavController.navigate(Main) {
                                    popUpTo(Splash) { inclusive = true }
                                }
                            }
                        )
                    }
                    composable<Main> {
                        MainScreen()
                    }
                }
            }
        }
    }
}
