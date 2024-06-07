package com.ceritakita.app._core.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.recognition.presentation.screen.RecognitionResultScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.RecognitionResultScreen.name) {
        composable(NavigationScreen.RecognitionResultScreen.name) {
            RecognitionResultScreen(navController)

        }

    }
}