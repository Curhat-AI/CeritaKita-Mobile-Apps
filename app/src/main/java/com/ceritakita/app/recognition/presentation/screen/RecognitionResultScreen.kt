package com.ceritakita.app.recognition.presentation.screen

import CustomAppBar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.HeadingMedium
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.history.presentation.components.SelfHelpCard
import com.ceritakita.app.recognition.presentation.presentation.viewmodel.PredictViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecognitionResultScreen(
    navController: NavController,
    viewModel: PredictViewModel = hiltViewModel()
) {
    val textPrediction = viewModel.textPrediction.collectAsState().value
    val imagePrediction = viewModel.imagePrediction.collectAsState().value


    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            CustomAppBar(
                title = "Hasil Analisa",
                onBackClicked = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(WindowInsets.systemBars.asPaddingValues())
                .verticalScroll(
                    rememberScrollState()
                )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sample_image),
                    contentDescription = "Image Description",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop,
                )
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    TitleLarge(text = "Kamu membutuhkan bantuan profesional!")

                    Spacer(modifier = Modifier.height(8.dp))
                    BodyLarge(
                        text = "Kami menyarankan untuk segera berkonsultasi dengan psikolog",
                        color = TextColors.grey600
                    )

                }

            }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(
                        border = BorderStroke(1.dp, color = TextColors.grey200),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_verified_icon),
                            contentDescription = "Profile Icon",
                            modifier = Modifier.size(16.dp),
                            tint = TextColors.grey500
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        BodyMedium(text = "Status Mental Kamu")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    BodyLarge(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna",
                        color = TextColors.grey600
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .border(
                        border = BorderStroke(1.dp, color = TextColors.grey200),
                        shape = RoundedCornerShape(8.dp)
                    )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_verified_icon),
                            contentDescription = "Profile Icon",
                            modifier = Modifier.size(16.dp),
                            tint = TextColors.grey500
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        BodyMedium(text = "Hasil Analisa")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    BodyLarge(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                        color = TextColors.grey600
                    )

                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                HeadingMedium(text = "Rekomendasi Self Help")
                Spacer(modifier = Modifier.height(2.dp))
                BodyMedium(text = "Aktivitas mandiri yang bisa bantu kamu")
                Spacer(modifier = Modifier.height(16.dp))
                SelfHelpCard()
            }
        }
    }
