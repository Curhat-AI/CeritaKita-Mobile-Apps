package com.ceritakita.app.auth.presentation.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.textfield.CustomOutlinedTextField
import com.ceritakita.app._core.presentation.components.textfield.CustomPasswordTextField
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors


@Composable
fun RegisterScreen(navController: NavController) {
    val namaState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val passwordRepeatState = remember { mutableStateOf("") }
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
            value = namaState.value,
            onValueChange = { namaState.value = it },
            label = "Nama Lengkap",
            iconId = R.drawable.ic_profile_icon,
            placeholderText = "Enter your name"
        )
        Spacer(modifier = Modifier.heightIn(16.dp))
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
            label = "Kata Sandi",
            iconId = R.drawable.ic_password_icon,
            placeholderText = "Enter your password"
        )
        Spacer(modifier = Modifier.heightIn(16.dp))
        CustomPasswordTextField(
            value = passwordRepeatState.value,
            onValueChange = { passwordRepeatState.value = it },
            label = "Ulangi Kata Sandi",
            iconId = R.drawable.ic_password_icon,
            placeholderText = "Enter your password"
        )

        Spacer(modifier = Modifier.heightIn(40.dp))
        CustomButton(text = "Masuk", onClick = { /*TODO*/ }, buttonType = ButtonType.Primary)
        Spacer(modifier = Modifier.weight(0.1f))
            BodyMedium(
                modifier = Modifier.fillMaxWidth(),
                text = "Atau",
                color = TextColors.grey500,
                textAlign = TextAlign.Center,
            )

        Spacer(modifier = Modifier.weight(0.1f))
        CustomButton(text = "Masuk dengan Google", onClick = { /*TODO*/ }, buttonType = ButtonType.Secondary,
            icon = ImageVector.vectorResource(id = R.drawable.ic_google_sign_in),
            textButtonColor = Color.Black,
            outlineButtonColor = Color.Black
            )
        Spacer(modifier = Modifier.weight(0.1f))

        Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth(),

                ) {
                BodyMedium(
                    text = "Belum punya Akun?",
                    color = TextColors.grey500,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.widthIn(5.dp))
                BodyMedium(
                    text = "Login",
                    modifier = Modifier.clickable {  },
                    color = AppColors.linkColor,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
        }
    }
}


@Preview(showSystemUi = false, showBackground = true)
@Composable
fun RegisterScreen() {
    RegisterScreen(navController = rememberNavController())
}