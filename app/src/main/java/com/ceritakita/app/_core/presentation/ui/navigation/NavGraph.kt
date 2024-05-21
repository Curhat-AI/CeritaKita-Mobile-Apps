package com.ceritakita.app._core.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.auth.presentation.screen.LoginScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.LoginScreen.name) {
        composable(NavigationScreen.LoginScreen.name) { LoginScreen(navController) }
    }
}