package com.ceritakita.app.auth.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@Composable
fun EmailVerificationSuccessScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            modifier = Modifier.padding(top = 105.dp),
            painter = painterResource(id = R.drawable.img_success_verifikasi_email1),
            contentDescription = "Localized description",
            tint = Color.Unspecified,
        )
        Spacer(Modifier.height(16.dp))
        HeadingLarge(text = "Wohoo... Email kamu\n" +
                "berhasil diverifikasi!", color = TextColors.grey700)
        Spacer(Modifier.height(6.dp))
        BodyMedium(
            text = "Sekarang, lanjut atur preferensi kamu yuk!",
            color = TextColors.grey500,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(48.dp))

        CustomButton(text = "Selanjutnya", onClick = { /*TODO*/ }, buttonType = ButtonType.Primary)

    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewEmailVerificationSuccessScreen() {
    EmailVerificationSuccessScreen(navController = rememberNavController())
}