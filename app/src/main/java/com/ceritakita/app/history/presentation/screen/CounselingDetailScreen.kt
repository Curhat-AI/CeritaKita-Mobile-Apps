package com.ceritakita.app.history.presentation.screen

import CustomAppBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.TitleMedium
import com.ceritakita.app._core.presentation.components.texts.TitleSmall
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app.history.presentation.components.KonselingDetailCard
import com.ceritakita.app.history.presentation.components.KonselorDetailCard
import com.ceritakita.app.history.presentation.components.RatingReviewCard
import com.ceritakita.app.history.presentation.components.ReviewFormBottomSheet
import com.ceritakita.app.history.presentation.components.RingkasanPembayaranCard
import com.ceritakita.app.history.presentation.viewmodel.CounselingSessionDetailViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun CounselingDetailScreen(
    navController: NavController,
    sessionId: String,  // Assuming you pass sessionId to this screen
    viewModel: CounselingSessionDetailViewModel = hiltViewModel()
) {
    val sessionDetail by viewModel.sessionDetail.observeAsState()
    val counselorDetail by viewModel.counselorDetail.observeAsState()
    LaunchedEffect(sessionId) {
        viewModel.loadSessionAndCounselorDetails(sessionId)
    }
    // State untuk menampilkan bottom sheet
    var showReviewForm by remember { mutableStateOf(false) }

    // Function untuk membuka bottom sheet
    val openReviewForm = { showReviewForm = true }

    // Function untuk menutup bottom sheet
    val closeReviewForm = { showReviewForm = false }
    val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
    val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    Scaffold(
        contentColor = Color.White,
        topBar = {
            CustomAppBar(
                title = "Riwayat Konseling",
                onBackClicked = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
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
                    TitleSmall(
                        text = "Berlangsung",
                        color = AppColors.warningColor,
                        fontSize = 14.sp
                    )
                }
            }
            Spacer(modifier = Modifier.heightIn(10.dp))
            KonselorDetailCard(
                counselorName = counselorDetail?.name ?: "Loading...",
                counselorDetails = counselorDetail?.bio ?: "No details available",
                counselorExpertise = counselorDetail?.expertise ?: "No expertise",
                counselorExperience = counselorDetail?.experienceYears.toString() + " years"
            )
            Spacer(modifier = Modifier.heightIn(24.dp))
            TitleMedium(text = "Detail Konseling")
            Spacer(modifier = Modifier.heightIn(10.dp))
            KonselingDetailCard(
                counselingSchedule = sessionDetail?.let {
                    val start = dateFormat.format(it.startTime)
                    val end = timeFormat.format(it.endTime)
                    "$start - $end"
                } ?: "Loading...",
                counselingMedia = sessionDetail?.communicationPreference ?: "Loading...",
            )
            Spacer(modifier = Modifier.heightIn(24.dp))
            TitleMedium(text = "Ringkasan Biaya")
            Spacer(modifier = Modifier.heightIn(10.dp))
            RingkasanPembayaranCard(
                counselingPrice = formatToRupiah(sessionDetail?.counselingFee ?: 0),
                counselingDiscount = formatToRupiah(sessionDetail?.discount ?: 0),
                counselingPPN = formatToRupiah(sessionDetail?.tax ?: 0),
                counselingTotal = formatToRupiah(sessionDetail?.totalPayment ?: 0),
            )
            Spacer(modifier = Modifier.heightIn(24.dp))
            TitleMedium(text = "Ulasan Kamu")
            Spacer(modifier = Modifier.heightIn(10.dp))
            RatingReviewCard(rating = null, review = null, onWriteReviewClick = openReviewForm)
            Spacer(modifier = Modifier.heightIn(24.dp))
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
}

fun formatToRupiah(amount: Int): String {
    val format = NumberFormat.getCurrencyInstance(Locale("in", "ID"))
    return format.format(amount).replace("Rp", "Rp ").replace(",00", "")
}
