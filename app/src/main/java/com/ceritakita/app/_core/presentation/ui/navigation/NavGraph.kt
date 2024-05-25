package com.ceritakita.app._core.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.history.presentation.screen.HistoryScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationScreen.HistoryScreen.name) {
        composable(NavigationScreen.HistoryScreen.name) { HistoryScreen(navController) }
    }

}