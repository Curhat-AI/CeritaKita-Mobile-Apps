package com.ceritakita.app._core.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.auth.presentation.screen.EmailVerificationScreen
import com.ceritakita.app.auth.presentation.screen.EmailVerificationSuccessScreen
import com.ceritakita.app.auth.presentation.screen.LoginScreen
import com.ceritakita.app.auth.presentation.screen.RegisterScreen
import com.ceritakita.app.history.presentation.screen.CounselingDetailScreen
import com.ceritakita.app.history.presentation.screen.HistoryScreen
import com.ceritakita.app.psikolog_flow.presentation.screen.CounselorDetailScreen
import com.ceritakita.app.psikolog_flow.presentation.screen.CounselorListScreen
import com.ceritakita.app.psikolog_flow.presentation.screen.PaymentScreen
import com.ceritakita.app.recognition.presentation.screen.RecognitionResultScreen
import com.ceritakita.app.recognition.presentation.screen.TextRecognitionScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.RegisterScreen.name) {
        composable(NavigationScreen.RegisterScreen.name) {
            RegisterScreen(navController)
        }
        composable(NavigationScreen.LoginScreen.name) {
            LoginScreen(navController)
        }
        composable(NavigationScreen.EmailVerificationScreen.name) {
            EmailVerificationScreen(navController)
        }
        composable(NavigationScreen.EmailVerificationSuccess.name) {
            EmailVerificationSuccessScreen(navController)
        }
        composable(NavigationScreen.HistoryScreen.name) {
            HistoryScreen(navController)
        }
        composable(NavigationScreen.CounselingDetailScreen.name) {
            CounselingDetailScreen(navController)
        }
        composable(NavigationScreen.CounselorDetailScreen.name) {
            CounselorDetailScreen(navController)
        }
        composable(NavigationScreen.PaymentScreen.name) {
            PaymentScreen(navController)
        }
        composable(NavigationScreen.TextRecognitionScreen.name) {
            TextRecognitionScreen(navController)
        }
        composable(NavigationScreen.CounselorListScreen.name) {
            CounselorListScreen(navController)
        }
        composable(NavigationScreen.RecognitionResultScreen.name) {
            RecognitionResultScreen(navController)
        }
    }
}
