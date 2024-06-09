package com.ceritakita.app.auth.presentation.screen

import android.content.Intent
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.fields.CustomTextField
import com.ceritakita.app._core.presentation.components.textfield.CustomOutlinedTextField
import com.ceritakita.app._core.presentation.components.textfield.CustomPasswordTextField
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.ui.navigation.NavigationScreen
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

data class EmojiDataPoint(val value: Float, val emoji: String)

@Composable
fun LoginScreen(navController: NavController) {

    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 20.dp, vertical = 20.dp)

    ) {
        Spacer(modifier = Modifier.heightIn(15.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ) {

            Image(
                painter = painterResource(id = R.drawable.logosvg),
                contentDescription = "logo",
                Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.widthIn(10.dp))
            HeadingSmall(text = "CeritaKita")
        }
        Spacer(modifier = Modifier.heightIn(20.dp))
        HeadingLarge(text = "Masuk Ke Akun Kamu")
        Spacer(modifier = Modifier.heightIn(4.dp))
        BodyLarge(
            text = "Masuk untuk mengakses seluruh fitur CeritaKita",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start,
            color = TextColors.grey600
        )

        Spacer(modifier = Modifier.heightIn(24.dp))
        CustomOutlinedTextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = "Email",
            iconId = R.drawable.ic_email_icon,
            placeholderText = "Enter your email"
        )
        Spacer(modifier = Modifier.heightIn(16.dp))
        CustomPasswordTextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = "Password",
            iconId = R.drawable.ic_password_icon,
            placeholderText = "Enter your password"
        )
        Spacer(modifier = Modifier.heightIn(16.dp))

        BodyLarge(
            modifier = Modifier.align(Alignment.End),
            text = "Lupa Password?",
            fontWeight = FontWeight.Medium,
            color = AppColors.linkColor
        )
        Spacer(modifier = Modifier.heightIn(40.dp))
        CustomButton(text = "Masuk", onClick = {
            navController.navigate(NavigationScreen.CounselorListScreen.name)

        }, buttonType = ButtonType.Primary)
//        BodyMedium(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 30.dp),
//            text = "atau",
//            color = Color.Gray,
//            textAlign = TextAlign.Center
//        )
//        CustomButton(text = "Masuk", onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.weight(2f))
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(

            ) {
                BodyMedium(
                    text = "Belum punya Akun?",
                    color = TextColors.grey500,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.widthIn(5.dp))
                BodyMedium(
                    text = "Daftar",
                    color = AppColors.linkColor,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    LoginScreen(navController = rememberNavController())
}