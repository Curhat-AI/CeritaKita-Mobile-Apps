package com.ceritakita.app._core.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
<<<<<<< Updated upstream
import com.ceritakita.app.psikolog_flow.presentation.screen.PaymentScreen
import com.ceritakita.app.recognition.presentation.screen.TextRecognitionScreen
=======
import com.ceritakita.app.psikolog_flow.presentation.screen.CounselorListScreen
>>>>>>> Stashed changes


@Composable
fun Navigation(){
    val navController = rememberNavController()
<<<<<<< Updated upstream
    NavHost(navController = navController, startDestination = NavigationScreen.TextRecognitionScreen.name) {
        composable(NavigationScreen.TextRecognitionScreen.name) { TextRecognitionScreen(navController) }
=======
    NavHost(navController = navController, startDestination = NavigationScreen.CounselorListScreen.name) {
        composable(NavigationScreen.CounselorListScreen.name) { CounselorListScreen(navController) }
>>>>>>> Stashed changes
    }

}