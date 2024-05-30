package com.ceritakita.app.psikolog_flow.presentation.component

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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.BodySmall
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleBottomSheet(
    onReviewSubmit: (String, Int) -> Unit,
    onDismiss: () -> Unit
) {
    val reviewState = remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(true) }
    var rating by remember { mutableIntStateOf(0) }

    val days = listOf("Senin", "Selasa", "Rabu")
    val dates = listOf("19 Mei", "20 Mei", "21 Mei")
    var selectedIndex by remember { mutableStateOf(-1) }  // Initialise with -1 if no initial selection

    val handleDateClick = { index: Int ->
        selectedIndex = index
    }

    val times = listOf("09:00 WIB", "12:00 WIB", "09:00 WIB", "12:00 WIB")
    var selectedTimeIndex by remember { mutableStateOf(-1) }  // Initialise with -1 or any invalid index if no initial selection

    val handleTimeClick = { index: Int ->
        selectedTimeIndex = index
    }

    val durations = listOf("30 Menit", "1 Jam")
    var selectedDurationIndex by remember { mutableStateOf(-1) }  // Initialise with -1 or any invalid index if no initial selection

    val handleDurationClick = { index: Int ->
        selectedDurationIndex = index
    }

    var selectedMediaIndex by remember { mutableStateOf(0) }

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
                    selectedIndex = selectedTimeIndex,
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
                            text = "RP 329.000",
                            color = BrandColors.brandPrimary600,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                    CustomButton(
                        text = "Konfirmasi",
                        onClick = {
                            // Retrieve selections
                            val selectedDate =
                                if (selectedIndex >= 0) "${days[selectedIndex]} ${dates[selectedIndex]}" else "None"
                            val selectedTime =
                                if (selectedTimeIndex >= 0) times[selectedTimeIndex] else "None"
                            val selectedDuration =
                                if (selectedDurationIndex >= 0) durations[selectedDurationIndex] else "None"
                            val selectedMedia =
                                if (selectedMediaIndex == 0) "Voice Call" else "Video Call"

                            // Do something with these selections, e.g., submitting to a server
                            onReviewSubmit(
                                "Selected Date: $selectedDate, Time: $selectedTime, Duration: $selectedDuration, Media: $selectedMedia",
                                rating
                            )

                            // Close the bottom sheet
                            showBottomSheet = false
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}