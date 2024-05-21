package com.ceritakita.app.auth.presentation.screen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.button.ButtonPrimary
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.HeadingLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.components.textfield.TextFieldOutline
import com.ceritakita.app._core.presentation.components.textfield.TextFieldOutlinePassword

data class EmojiDataPoint(val value: Float, val emoji: String)

@Composable
fun LoginScreen(navController: NavController) {


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 20.dp, vertical = 40.dp)

    ){
        Spacer(modifier = Modifier.heightIn(15.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround

        ){

            Image(painter = painterResource(id = R.drawable.logosvg) , contentDescription = "logo")
            Spacer(modifier = Modifier.widthIn(10.dp))
            HeadingSmall(text = "Curhat.ai")
        }
        Spacer(modifier = Modifier.heightIn(20.dp))
        HeadingLarge(text = "Masuk Ke Akun Kamu")
        Spacer(modifier = Modifier.heightIn(10.dp))
        BodyMedium(
            text = "Masuk untuk mengakses seluruh fitur Curhat.asadadi",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start // Atau TextAlign.Center sesuai kebutuhan
        )

        Spacer(modifier = Modifier.heightIn(10.dp))
        TextFieldOutline()
        Spacer(modifier = Modifier.heightIn(10.dp))
        TextFieldOutlinePassword()
        Spacer(modifier = Modifier.heightIn(10.dp))

        BodyMedium(modifier = Modifier.align(Alignment.End),text = "Lupa Password?", color = Color.Blue)

        Spacer(modifier = Modifier.heightIn(10.dp))
        CustomButton(text = "Masuk", onClick = { /*TODO*/ }, buttonType = ButtonType.Primary)
        BodyMedium(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp) ,text = "atau", color = Color.Gray, textAlign = TextAlign.Center)
        ButtonPrimary()
        Spacer(modifier = Modifier.weight(2f)) // Menambahkan ruang kosong untuk mendorong konten ke bawah
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
Row(

){
    BodyMedium(
        modifier = Modifier
            .padding(vertical = 30.dp),
        text = "Belum punya Akun?",
        color = Color.Gray,
        textAlign = TextAlign.Center
    )
    Spacer(Modifier.widthIn(5.dp))
    BodyMedium(
        modifier = Modifier
            .padding(vertical = 30.dp),
        text = "Daftar",
        color = Color.Blue,
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