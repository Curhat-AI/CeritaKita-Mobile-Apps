package com.ceritakita.app.profile.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ceritakita.app._core.presentation.components.texts.TitleLarge

@Composable
fun ProfileScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ){
        TitleLarge(text = "INI ADALAH HALAMAN PROFILE")
    }
}