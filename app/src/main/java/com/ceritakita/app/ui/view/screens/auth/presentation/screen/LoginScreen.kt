package com.ceritakita.app.ui.view.screens.auth.presentation.screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController


@Composable
fun LoginScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        Text("Curhat In", style = TextStyle(color = Color.Gray))
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    LoginScreen(navController = rememberNavController())
}