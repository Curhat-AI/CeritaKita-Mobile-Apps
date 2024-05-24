package com.ceritakita.app.template_feature.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge

@Composable
fun PaymentSuccessScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ){
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewPaymentSuccessScreenHomeScreen() {
    PaymentSuccessScreen(navController = rememberNavController())
}