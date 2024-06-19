package com.ceritakita.app.counselor.presentation.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
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
import com.ceritakita.app.counselor.presentation.viewmodel.BookingViewModel
import com.ceritakita.app.counselor.presentation.viewmodel.CounselorListViewModel
import com.ceritakita.app.counselor.presentation.viewmodel.CounselorScheduleViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun CounselorDetailScreen(
    navController: NavController,
    counselorId: String,
    viewModel: CounselorListViewModel = hiltViewModel(),
    scheduleViewModel: CounselorScheduleViewModel = hiltViewModel(),
    bookingViewModel: BookingViewModel = hiltViewModel()
) {
    var showReviewForm by remember { mutableStateOf(false) }
    var selectedDateIndex by remember { mutableStateOf(0) }
    var selectedTimeIndex by remember { mutableStateOf(0) }
    val timeSlots = remember { mutableStateOf(listOf<String>()) }

    val counselor by viewModel.selectedCounselor.observeAsState()
    val schedules by scheduleViewModel.schedules.observeAsState(emptyList())

    val onReviewSubmit = { startTime: Date, endTime: Date, communicationPreference: String, counselingFee: Int ->
        bookingViewModel.bookCounselingSession(
            counselorId = counselorId,
            patientId = "HardcodedPatientId", // Replace with actual patient ID
            scheduleId = schedules[selectedDateIndex].id,
            startTime = startTime,
            endTime = endTime,
            communicationPreference = communicationPreference,
            counselingFee = counselingFee
        ).addOnSuccessListener { documentReference ->
            val route = "paymentScreen/${documentReference.id}/${counselorId}/HardcodedPatientId/${schedules[selectedDateIndex].id}/$startTime/$endTime/$communicationPreference/$counselingFee"
            navController.navigate(route) {
                popUpTo("counselorDetailScreen") { inclusive = true }
            }
        }
        showReviewForm = false
    }

    val closeReviewForm = { showReviewForm = false }

    val handleDateClick = { index: Int ->
        selectedDateIndex = index
        if (selectedDateIndex >= 0 && selectedDateIndex < schedules.size) {
            timeSlots.value = schedules[selectedDateIndex].timeSlots
                .filter { it.status == "Tersedia" }
                .map { SimpleDateFormat("HH:mm", Locale.getDefault()).format(it.startTime) + " WIB" }
        } else {
            timeSlots.value = emptyList()
        }
    }

    val handleTimeClick = { index: Int ->
        selectedTimeIndex = index
    }

    LaunchedEffect(key1 = counselorId) {
        Log.d("CounselorDetailScreen", "Counselor ID received: $counselorId")
        viewModel.getCounselorDetails(counselorId)
        scheduleViewModel.loadSchedules(counselorId)
    }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()

    Log.d("CurrentRoute", "Current Route: ${currentBackStackEntry?.destination?.route}")
    Log.d("CurrentRoute", "Current Arguments: ${currentBackStackEntry?.arguments}")

    Column(
        Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        counselor?.let { counselorData ->
            Log.d("CounselorDetailScreen", "Displaying data for counselor: ${counselorData.name}")
            Log.d("CounselorDetailScreen", "Displaying data for counselor: ${counselorData}")
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
                            BodyMedium(text = "${counselorData.experienceYears} Tahun")
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
                            BodyMedium(text = "${counselorData.experienceYears}")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                BodyLarge(
                    text = counselorData.bio,
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
                    text = counselorData.expertise,
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
                    days = schedules.map {
                        SimpleDateFormat(
                            "EEEE",
                            Locale.getDefault()
                        ).format(it.availableDate!!)
                    },
                    dates = schedules.map {
                        SimpleDateFormat("dd MMM", Locale.getDefault()).format(
                            it.availableDate!!
                        )
                    },
                    selectedIndex = selectedDateIndex,
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
                if (selectedDateIndex >= 0 && selectedDateIndex < schedules.size) {
                    val timeSlots = schedules[selectedDateIndex].timeSlots
                    Log.d("CounselorDetailScreen", "Displaying TimeSlots: ${timeSlots.size}")
                    timeSlots.forEach { slot ->
                        Log.d("CounselorDetailScreen", "TimeSlot Start Time: ${slot.startTime}")
                    }

                    TimeChipRow(
                        times = timeSlots.map {
                            SimpleDateFormat(
                                "HH:mm",
                                Locale.getDefault()
                            ).format(it.startTime!!) + " WIB"
                        },
                        selectedIndex = selectedTimeIndex,
                        onTimeClick = handleTimeClick
                    )
                } else {
                    Log.d(
                        "CounselorDetailScreen",
                        "No TimeSlots to display or invalid selectedDateIndex: $selectedDateIndex"
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                CustomButton(
                    text = "Pilih Psikolog",
                    onClick = { showReviewForm = true },
                    buttonType = ButtonType.Primary
                )

                if (showReviewForm) {
                    ScheduleBottomSheet(
                        onReviewSubmit = onReviewSubmit,
                        onDismiss = closeReviewForm,
                        selectedDateIndex = selectedDateIndex,
                        selectedTimeIndex = selectedTimeIndex,
                        days = schedules.map {
                            SimpleDateFormat(
                                "EEEE",
                                Locale.getDefault()
                            ).format(it.availableDate!!)
                        },
                        dates = schedules.map {
                            SimpleDateFormat("dd MMM", Locale.getDefault()).format(
                                it.availableDate!!
                            )
                        },
                        times = timeSlots.value,
                        counselorType = counselorData.counselorType,
                        counselorId = counselorData.id,
                        scheduleId = schedules[selectedDateIndex].id,
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