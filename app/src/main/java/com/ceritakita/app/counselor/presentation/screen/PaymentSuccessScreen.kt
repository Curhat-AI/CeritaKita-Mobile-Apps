package com.ceritakita.app.counselor.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge

@Composable
fun PaymentSuccessScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_payment_succes),
            contentDescription = "Image Description",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .aspectRatio(1f),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.heightIn(16.dp))
        HeadingLarge(
            text = "Pembayaran Berhasil!",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.heightIn(8.dp))
        BodyLarge(
            text = "Pembayaran kamu berhasil diverifikasi. Sekarang kamu dapat melakukan konseling sesuai jadwal yang kamu ambil",
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.heightIn(40.dp))
        CustomButton(text = "Kembali ke Beranda", onClick = { /*TODO*/ })
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun PreviewPaymentSuccessScreenHomeScreen() {
    PaymentSuccessScreen(navController = rememberNavController())
}