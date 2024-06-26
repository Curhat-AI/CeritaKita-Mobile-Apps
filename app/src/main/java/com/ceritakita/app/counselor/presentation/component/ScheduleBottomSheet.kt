package com.ceritakita.app.counselor.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.counselor.data.constant.PricingConstants
import com.ceritakita.app.counselor.presentation.viewmodel.BookingViewModel
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleBottomSheet(
    onReviewSubmit: (Date, Date, String, Int) -> Unit,
    onDismiss: () -> Unit,
    selectedDateIndex: Int,
    selectedTimeIndex: Int,
    days: List<String>,
    dates: List<String>,
    times: List<String>,
    counselorType: String,
    counselorId: String,
    scheduleId: String,
    bookingViewModel: BookingViewModel = hiltViewModel()
) {
    val reviewState = remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(true) }
    var rating by remember { mutableIntStateOf(0) }

    var selectedIndex by remember { mutableStateOf(selectedDateIndex) }
    val handleDateClick = { index: Int ->
        selectedIndex = index
        // Update times when date changes
        // Here, you might need additional logic to update times based on the new selected index
    }

    var selectedTimeIndexState by remember { mutableStateOf(selectedTimeIndex) }
    val handleTimeClick = { index: Int ->
        selectedTimeIndexState = index
    }

    val durations = listOf("30 Menit", "1 Jam")
    var selectedDurationIndex by remember { mutableStateOf(-1) }
    val handleDurationClick = { index: Int ->
        selectedDurationIndex = index
    }

    var selectedMediaIndex by remember { mutableStateOf(0) }
    val isLoading by bookingViewModel.isLoading.observeAsState(false)

    fun calculatePrice(): Int {
        val hourlyRate = when (counselorType) {
            "professional" -> PricingConstants.PROFESSIONAL_COUNSELING_HOUR_RATE
            "peer" -> PricingConstants.PEER_COUNSELING_HOUR_RATE
            else -> 0
        }
        val durationFactor = when (selectedDurationIndex) {
            0 -> 0.5 // 30 Menit
            1 -> 1.0 // 1 Jam
            else -> 0.0
        }
        return (hourlyRate * durationFactor).toInt()
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = {
                showBottomSheet = false
                onDismiss()
            }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .imePadding()
            ) {
                HeadingSmall(text = "Konfirmasi Jadwal & Media Konseling")
                Spacer(modifier = Modifier.height(4.dp))
                BodyLarge(text = "Pastikan jadwal yang kamu pilih sudah sesuai")
                Spacer(modifier = Modifier.height(16.dp))
                LabelLarge(text = "Pilih Tanggal Konseling")
                Spacer(modifier = Modifier.height(10.dp))
                DateChipRow(
                    days = days,
                    dates = dates,
                    selectedIndex = selectedIndex,
                    onDateClick = handleDateClick
                )
                Spacer(modifier = Modifier.height(20.dp))
                LabelLarge(text = "Pilih Waktu Konseling")
                Spacer(modifier = Modifier.height(10.dp))
                TimeChipRow(
                    times = times,
                    selectedIndex = selectedTimeIndexState,
                    onTimeClick = handleTimeClick
                )
                Spacer(modifier = Modifier.height(20.dp))
                LabelLarge(text = "Pilih Durasi Konseling")
                Spacer(modifier = Modifier.height(8.dp))
                DurationChipRow(
                    durations = durations,
                    selectedIndex = selectedDurationIndex,
                    onDurationClick = handleDurationClick
                )
                Spacer(modifier = Modifier.height(24.dp))
                Divider(thickness = 1.dp, color = TextColors.grey200)
                Spacer(modifier = Modifier.height(24.dp))
                LabelLarge(text = "Pilih Media Konseling")
                Spacer(modifier = Modifier.height(10.dp))
                MediaChipRow(
                    selectedMediaIndex = selectedMediaIndex,
                    onMediaClick = { index ->
                        selectedMediaIndex = index
                    }
                )
                Spacer(modifier = Modifier.height(24.dp))
                Divider(thickness = 1.dp, color = TextColors.grey200)
                Spacer(modifier = Modifier.height(32.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                    ) {
                        BodySmall(text = "Total bayar")
                        Spacer(modifier = Modifier.height(4.dp))
                        HeadingSmall(
                            text = "RP ${formatCurrency(calculatePrice())}",
                            color = BrandColors.brandPrimary600,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                    CustomButton(
                        text = "Konfirmasi",
                        onClick = {
                            // Combine date and time with current year
                            val calendar = Calendar.getInstance()
                            val currentYear = calendar.get(Calendar.YEAR)
                            val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                            val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
                            val dateString = "${dates[selectedIndex]} $currentYear"
                            val timeString = times[selectedTimeIndexState]

                            val selectedDate = dateFormat.parse(dateString)
                            val selectedTime = timeFormat.parse(timeString)

                            // Set the selectedDate to the selectedTime
                            calendar.time = selectedDate
                            calendar.set(Calendar.HOUR_OF_DAY, selectedTime.hours)
                            calendar.set(Calendar.MINUTE, selectedTime.minutes)
                            val startTime = calendar.time

                            // Calculate end time based on selected duration
                            val durationMinutes = if (selectedDurationIndex == 0) 30 else 60
                            calendar.add(Calendar.MINUTE, durationMinutes)
                            val endTime = calendar.time

                            // Get communication preference
                            val communicationPreference =
                                if (selectedMediaIndex == 0) "WhatsApp" else "Google Meet"
                            // Calculate counseling fee
                            val counselingFee = calculatePrice()
                            // Call the onReviewSubmit callback
                            onReviewSubmit(startTime, endTime, communicationPreference, counselingFee)
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

fun formatCurrency(amount: Int): String {
    val format = NumberFormat.getNumberInstance(Locale("id", "ID"))
    return format.format(amount)
}