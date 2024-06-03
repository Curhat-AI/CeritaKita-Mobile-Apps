package com.ceritakita.app._core.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.psikolog_flow.presentation.screen.PaymentScreen
import com.ceritakita.app.recognition.presentation.screen.TextRecognitionScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.TextRecognitionScreen.name) {
        composable(NavigationScreen.TextRecognitionScreen.name) { TextRecognitionScreen(navController) }
    }

}