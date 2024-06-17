package com.ceritakita.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.ceritakita.app._core.presentation.ui.navigation.Navigation
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation()
            SetupSystemBars()
        }
    }
}

@Composable
fun SetupSystemBars() {
    val systemUiController = rememberSystemUiController()
    val isDarkTheme = isSystemInDarkTheme()
    SideEffect {
        systemUiController.setNavigationBarColor(
            color = if (isDarkTheme) Color.Black else Color.White,
            darkIcons = !isDarkTheme
        )
    }
}