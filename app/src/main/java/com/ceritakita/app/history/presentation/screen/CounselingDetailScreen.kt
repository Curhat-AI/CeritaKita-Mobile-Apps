package com.ceritakita.app.history.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.TitleMedium
import com.ceritakita.app._core.presentation.components.texts.TitleSmall
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app.history.presentation.components.KonselingDetailCard
import com.ceritakita.app.history.presentation.components.KonselorDetailCard
import com.ceritakita.app.history.presentation.components.RatingReviewCard
import com.ceritakita.app.history.presentation.components.ReviewFormBottomSheet
import com.ceritakita.app.history.presentation.components.RingkasanPembayaranCard

@Composable
fun CounselingDetailScreen(navController: NavController) {
    // State untuk menampilkan bottom sheet
    var showReviewForm by remember { mutableStateOf(false) }

    // Function untuk membuka bottom sheet
    val openReviewForm = { showReviewForm = true }

    // Function untuk menutup bottom sheet
    val closeReviewForm = { showReviewForm = false }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.sample_image),
            contentDescription = "Image Description",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.heightIn(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitleMedium(text = "Tentang Konselor")
            Box(
                modifier = Modifier
                    .background(
                        color = AppColors.warningColor.copy(alpha = 0.16f),
                        shape = CircleShape
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                TitleSmall(text = "Berlangsung", color = AppColors.warningColor, fontSize = 14.sp)
            }
        }
        Spacer(modifier = Modifier.heightIn(10.dp))
        KonselorDetailCard(
            counselorName = "Dr. John Doe",
            counselorDetails = "Speciality: Psychology",
            counselorExpertise = "Psychology",
            counselorExperience = "10 years"
        )
        Spacer(modifier = Modifier.heightIn(24.dp))
        TitleMedium(text = "Detail Konseling")
        Spacer(modifier = Modifier.heightIn(10.dp))
        KonselingDetailCard(
            counselingSchedule = "Senin, 20 Mei • 14:00 - 14:30 WIB",
            counselingMedia = "Voice Call"
        )
        Spacer(modifier = Modifier.heightIn(24.dp))
        TitleMedium(text = "Ringkasan Biaya")
        Spacer(modifier = Modifier.heightIn(10.dp))
        RingkasanPembayaranCard()
        Spacer(modifier = Modifier.heightIn(24.dp))
        TitleMedium(text = "Ulasan Kamu")
        Spacer(modifier = Modifier.heightIn(10.dp))
        RatingReviewCard(rating = null, review = null, onWriteReviewClick = openReviewForm)

        if (showReviewForm) {
            ReviewFormBottomSheet(
                onReviewSubmit = { rating, review ->
                    closeReviewForm()
                },
                onDismiss = closeReviewForm
            )
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun CounselingDetailScreenPreview() {
    CounselingDetailScreen(navController = rememberNavController())
}