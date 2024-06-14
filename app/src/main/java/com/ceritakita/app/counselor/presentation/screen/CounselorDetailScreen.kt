package com.ceritakita.app.counselor.presentation.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.ButtonType
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.counselor.presentation.component.DateChipRow
import com.ceritakita.app.counselor.presentation.component.ScheduleBottomSheet
import com.ceritakita.app.counselor.presentation.component.TimeChipRow
import com.ceritakita.app.counselor.presentation.viewmodel.CounselorListViewModel

@Composable
fun CounselorDetailScreen(
    navController: NavController,
    counselorId: String,
    viewModel: CounselorListViewModel = hiltViewModel()
) {
    var showReviewForm by remember { mutableStateOf(false) }
    val counselor by viewModel.selectedCounselor.observeAsState()
    // Function to handle the submission from the bottom sheet
    val onReviewSubmit = { review: String, rating: Int ->
        // Placeholder for what to do on review submit, e.g., navigate or show a toast
        navController.navigate("NextScreenRoute") {
            // Pass the review and rating as arguments or set them somewhere they can be used
        }
        showReviewForm = false // Close the bottom sheet after submitting
    }

    // Function to close the bottom sheet
    val closeReviewForm = { showReviewForm = false }

    val days = listOf("Senin", "Selasa", "Rabu")
    val dates = listOf("19 Mei", "20 Mei", "21 Mei")
    var selectedIndex by remember { mutableStateOf(-1) }

    val handleDateClick = { index: Int ->
        selectedIndex = index
    }

    val times = listOf("09:00 WIB", "12:00 WIB", "15:00 WIB", "18:00 WIB")
    var selectedTimeIndex by remember { mutableStateOf(-1) }

    val handleTimeClick = { index: Int ->
        selectedTimeIndex = index
    }

    LaunchedEffect(key1 = counselorId) {
        Log.d("CounselorDetailScreen", "Counselor ID received: $counselorId")
        viewModel.getCounselorDetails(counselorId)
    }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Log.d("CurrentRoute", "Current Route: ${currentBackStackEntry?.destination?.route}")
    Log.d("CurrentRoute", "Current Arguments: ${currentBackStackEntry?.arguments}")


    Column(
        Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
            .verticalScroll(rememberScrollState())
    ) {
        counselor?.let { counselorData ->
            Log.d("CounselorDetailScreen", "Displaying data for counselor: ${counselorData.name}")
            Image(
                painter = painterResource(id = R.drawable.sample_image),
                contentDescription = "Profile Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                TitleLarge(
                    text = counselorData.name,
                    fontSize = 22.sp,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Box(
                        modifier = Modifier
                            .border(1.dp, TextColors.grey300, RoundedCornerShape(200.dp))
                            .padding(vertical = 10.dp, horizontal = 16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_work_icon),
                                contentDescription = "Work Experience Icon",
                                modifier = Modifier.size(20.dp),
                                tint = AppColors.warningColor
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            BodyMedium(text = "5 Tahun")
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .border(1.dp, TextColors.grey300, RoundedCornerShape(200.dp))
                            .padding(vertical = 10.dp, horizontal = 16.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_star_icon),
                                contentDescription = "Rating Icon",
                                modifier = Modifier.size(20.dp),
                                tint = AppColors.warningColor
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            BodyMedium(text = "4.5 (120)")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                BodyLarge(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                    color = TextColors.grey600,
                )
                Divider(
                    thickness = 1.dp,
                    color = TextColors.grey200,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                TitleLarge(
                    text = "Spesialisasi",
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                BodyLarge(
                    text = "Pekerjaan, Percintaan, Positif Psikologi, Karir, Mindfulness, Person Center Therapy (PCT)",
                    color = TextColors.grey600,
                )
                Divider(
                    thickness = 1.dp,
                    color = TextColors.grey200,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                TitleLarge(
                    text = "Jadwal Tersedia",
                )
                Spacer(modifier = Modifier.height(10.dp))
                DateChipRow(
                    days = days,
                    dates = dates,
                    selectedIndex = selectedIndex,
                    onDateClick = handleDateClick
                )
                Divider(
                    thickness = 1.dp,
                    color = TextColors.grey200,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
                TitleLarge(
                    text = "Waktu Tersedia",
                )
                Spacer(modifier = Modifier.height(10.dp))
                TimeChipRow(
                    times = times,
                    selectedIndex = selectedTimeIndex,
                    onTimeClick = handleTimeClick
                )
                Spacer(modifier = Modifier.height(32.dp))
                CustomButton(
                    text = "Pilih Psikolog",
                    onClick = { showReviewForm = true },
                    buttonType = ButtonType.Primary
                )

                if (showReviewForm) {
                    ScheduleBottomSheet(
                        onReviewSubmit = onReviewSubmit,
                        onDismiss = closeReviewForm
                    )
                }
            }
        } ?: run {
            Log.d("CounselorDetailScreen", "Counselor data is null")
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                BodyLarge(text = "Data tidak ditemukan")
            }
        }
    }
}