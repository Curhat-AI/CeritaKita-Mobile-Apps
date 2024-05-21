package com.ceritakita.app.template_feature.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge

@Composable
fun TemplatePage(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        HeadingLarge("Curhat In")
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    TemplatePage(navController = rememberNavController())
}