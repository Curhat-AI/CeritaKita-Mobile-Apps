package com.ceritakita.app.recognition.presentation.screen

import CustomAppBar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

@Composable
fun RecognitionResultScreen(
    navController: NavController,
    viewModel: PredictViewModel = hiltViewModel()
) {
    val textPrediction = viewModel.textPrediction.collectAsState().value
    val imagePrediction = viewModel.imagePrediction.collectAsState().value
    val predictionStatus = viewModel.predictionStatus.collectAsState().value

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
                .padding(horizontal = 16.dp)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            textPrediction?.let {
                Text(text = "Text Prediction: $it", modifier = Modifier.padding(vertical = 8.dp))
            }
            imagePrediction?.let {
                Text(text = "Image Prediction: $it", modifier = Modifier.padding(vertical = 8.dp))
            }

            Spacer(modifier = Modifier.height(16.dp))
            TitleLarge(text = "Kamu membutuhkan bantuan profesional!")
            Spacer(modifier = Modifier.height(8.dp))
            BodyLarge(
                text = "Kami menyarankan untuk segera berkonsultasi dengan psikolog",
                color = TextColors.grey600
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
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
            Column {
                HeadingMedium(text = "Rekomendasi Self Help")
                Spacer(modifier = Modifier.height(2.dp))
                BodyMedium(text = "Aktivitas mandiri yang bisa bantu kamu")
                Spacer(modifier = Modifier.height(16.dp))
                SelfHelpCard()
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}