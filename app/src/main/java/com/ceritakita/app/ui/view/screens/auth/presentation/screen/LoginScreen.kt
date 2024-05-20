package com.ceritakita.app.ui.view.screens.auth.presentation.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app.ui.view.main_component.TextBigDescription
import com.ceritakita.app.ui.view.main_component.TextBigHeader
import com.ceritakita.app.ui.view.main_component.TextMediumDescription


@Composable
fun LoginScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize() .padding(WindowInsets.systemBars.asPaddingValues()).padding(horizontal = 20.dp)
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ){

            Image(painter = painterResource(id = R.drawable.logosvg) , contentDescription = "logo")
            Spacer(modifier = Modifier.widthIn(5.dp))
            TextBigHeader(text = "Curhat.ai")
        }
        Spacer(modifier = Modifier.heightIn(10.dp))
        TextBigHeader(text = "Masuk Ke Akun Kamu", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 26.sp))
        Spacer(modifier = Modifier.heightIn(5.dp))
        TextMediumDescription(text = "Masuk untuk mengakses seluruh fitur Curhat.ai",)
        Spacer(modifier = Modifier.heightIn(10.dp))
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    LoginScreen(navController = rememberNavController())
}