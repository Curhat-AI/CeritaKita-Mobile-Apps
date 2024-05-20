package com.ceritakita.app.ui.view.screens.template_feature.presentation.screen


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
import com.ceritakita.app.ui.view.main_component.TextBigHeader


@Composable
fun TemplatePage(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        TextBigHeader("Curhat In", style = TextStyle(color = Color.Gray))
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    TemplatePage(navController = rememberNavController())
}