package com.ceritakita.app.auth.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.components.otp.OtpInputRow
import com.ceritakita.app._core.presentation.components.otp.OtpType

@Composable
fun EmailVerificationScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        OtpInputRow(OtpType.Number)
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewEmailVerificationScreen() {
    EmailVerificationScreen(navController = rememberNavController())
}
