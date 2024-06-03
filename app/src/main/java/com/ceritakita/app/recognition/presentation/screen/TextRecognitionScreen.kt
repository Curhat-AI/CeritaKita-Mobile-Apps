package com.ceritakita.app.recognition.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app._core.presentation.ui.theme.dmSansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextRecognitionScreen(
    navController: NavController
) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(WindowInsets.systemBars.asPaddingValues())
        ) {
            TitleLarge(
                text = "Ceritakan tentang keluh kesahmu",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            BodyLarge(
                text = "Ceritain yuk apa yang kamu rasakan saat ini! Biar kami lebih tau tentang apa yang kamu rasakan",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Divider(
                thickness = 1.dp,
                color = TextColors.grey200,
                modifier = Modifier.padding(top = 24.dp, bottom = 10.dp)
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 4.dp, vertical = 0.dp),
                value = textFieldValue,
                onValueChange = { newText ->
                    textFieldValue = newText
                },
                textStyle = TextStyle(
                    fontFamily = dmSansFontFamily,
                    fontSize = 16.sp,
                    color = TextColors.grey700,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 16 * 1.5.sp
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                placeholder = { BodyLarge(text = "Ceritain disini yuk..") }
            )
            CustomButton(
                text = "Selanjutnya",
                onClick = { /*TODO*/ },
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}