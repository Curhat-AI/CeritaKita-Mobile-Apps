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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.HeadingMedium
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app._core.presentation.ui.theme.dmSansFontFamily
import com.ceritakita.app.history.presentation.components.SelfHelpCard
import com.ceritakita.app.recognition.presentation.data.constant.SelfHelpData
import com.ceritakita.app.recognition.presentation.presentation.viewmodel.PredictViewModel

@Composable
fun RecognitionResultScreen(
    navController: NavController,
    viewModel: PredictViewModel = hiltViewModel()
) {
    val mentalIssuePrediction = viewModel.mentalIssuePrediction.collectAsState().value
    val emotion = mentalIssuePrediction?.firstOrNull()
    val textPrediction = viewModel.textPrediction.collectAsState().value
    val imagePrediction = viewModel.imagePrediction.collectAsState().value
    val predictionStatus = viewModel.predictionStatus.collectAsState().value

    val material = emotion.let { SelfHelpData.selfHelpMaterials[it] }

    Scaffold(
        containerColor = Color.White,
        topBar = {
            CustomAppBar(
                title = "Hasil Analisa",
                onBackClicked = { navController.navigate("homeScreen") }
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
                    Text(
                        text = buildAnnotatedString {
                            append("Berdasarkan hasil sistem AI kami, kamu mungkin merasakan emosi ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(textPrediction?.getOrNull(0).orEmpty())
                            }
                            append(" dan ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(textPrediction?.getOrNull(1).orEmpty())
                            }
                            append(" dari ceritamu, serta ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(imagePrediction?.getOrNull(0).orEmpty())
                            }
                            append(" dan ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(imagePrediction?.getOrNull(1).orEmpty())
                            }
                            append(". Sistem kami juga menunjukkan kemungkinan kamu memiliki masalah psikologi ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(emotion.orEmpty())
                            }
                            append(". Jika kamu merasa sedih, cemas, marah, atau kekosongan yang mendalam dan berkepanjangan, mungkin kamu memiliki gangguan mental dan membutuhkan bantuan profesional.")
                        },
                        color = TextColors.grey600,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = dmSansFontFamily,
                        lineHeight = 16.sp * 1.5,
                        textAlign = TextAlign.Start
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
                    Text(
                        text = buildAnnotatedString {
                            append("Dari emosi ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(textPrediction?.getOrNull(0).orEmpty())
                            }
                            append(" dan ")
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                                append(textPrediction?.getOrNull(1).orEmpty())
                            }
                            append(", refleksikan mengapa kamu merasakan hal tersebut. Pertimbangkan apakah ada faktor lain yang memengaruhinya. Cermati cerita yang telah kamu tuliskan untuk memahami penyebab emosimu. Setelah memahami, pikirkan tindakan yang lebih baik berdasarkan perasaan tersebut. Jika emosi membuatmu melakukan hal A, tetapi sebenarnya kamu ingin melakukan hal B, renungkan hal B dan cara terbaik untuk merespons ceritamu. Terapkan pemahaman ini untuk kehidupan yang lebih baik. Semoga sukses!")
                        },
                        color = TextColors.grey600,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = dmSansFontFamily,
                        lineHeight = 16.sp * 1.5,
                        textAlign = TextAlign.Start
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Column {
                HeadingMedium(text = "Rekomendasi Self Help")
                Spacer(modifier = Modifier.height(2.dp))
                BodyMedium(text = "Aktivitas mandiri yang bisa bantu kamu")
                Spacer(modifier = Modifier.height(16.dp))
                SelfHelpCard(
                    mainTitle = material?.mainTitle ?: "Lorem Ipsum Dolor Sit Amet",
                    mainDescription = material?.mainDescription ?: "Default description",
                    session = material?.sessions?.firstOrNull(),
                    remainingSessionsCount = (material?.sessions?.size ?: 1) - 1,
                    imageResId = material?.imageResId ?: R.drawable.sample_image,
                    onSeeMoreClick = { navController.navigate("selfHelpScreen/$emotion") }
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}