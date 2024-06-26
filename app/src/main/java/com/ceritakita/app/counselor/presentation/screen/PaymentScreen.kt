package com.ceritakita.app.counselor.presentation.screen

import CustomAppBar
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyMedium
import com.ceritakita.app._core.presentation.components.texts.LabelLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.components.texts.TitleMedium
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.counselor.presentation.component.PaymentMethodBottomSheet
import com.ceritakita.app.counselor.presentation.component.PaymentOption
import com.ceritakita.app.counselor.presentation.viewmodel.BookingViewModel
import com.ceritakita.app.history.presentation.components.KonselingDetailCard
import com.ceritakita.app.history.presentation.components.RingkasanPembayaranCard
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun PaymentScreen(
    navController: NavController,
    counselorId: String,
    patientId: String,
    scheduleId: String,
    startTime: String,
    endTime: String,
    communicationPreference: String,
    counselingFee: Int,
    sessionId: String,
    bookingViewModel: BookingViewModel = hiltViewModel()
) {
    var selectedPaymentOption by remember { mutableStateOf<PaymentOption?>(null) }
    var showPaymentMethodSheet by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    val ewalletOptions = listOf(
        PaymentOption("ew1", "OVO", R.drawable.logo_ovo),
        PaymentOption("ew2", "GoPay", R.drawable.logo_gopay),
        PaymentOption("ew3", "Dana", R.drawable.logo_dana)
    )
    val bankOptions = listOf(
        PaymentOption("b1", "BCA", R.drawable.logo_bca),
        PaymentOption("b2", "Mandiri", R.drawable.logo_mandiri),
        PaymentOption("b3", "BRI", R.drawable.logo_bri)
    )

    val formattedStartTime = formatDateTime(startTime)
    val formattedEndTime = formatDateTime(endTime, "HH:mm")
    val formattedFee = formatCurrency(counselingFee)

    Scaffold(
        containerColor = Color.White,
        topBar = {
            CustomAppBar(
                title = "Pembayaran",
                onBackClicked = { navController.navigateUp() }
            )
        }
    ) { innerPadding ->
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Row {
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
                        TitleLarge(text = "Yanuar Tri Laksono, M.Psi., Psikolog")
                        Spacer(modifier = Modifier.height(8.dp))
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
                Spacer(modifier = Modifier.height(24.dp))
                TitleMedium(text = "Ringkasan Konseling")
                Spacer(modifier = Modifier.heightIn(10.dp))
                KonselingDetailCard(
                    counselingSchedule = "$formattedStartTime - $formattedEndTime WIB",
                    counselingMedia = communicationPreference
                )
                Spacer(modifier = Modifier.height(24.dp))
                TitleMedium(text = "Ringkasan Pembayaran")
                Spacer(modifier = Modifier.heightIn(10.dp))
                RingkasanPembayaranCard(
                    counselingPrice = formattedFee,
                    counselingTotal = formattedFee
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = { showPaymentMethodSheet = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                        contentColor = TextColors.grey500,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 1.dp,
                            color = TextColors.grey300,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                    elevation = null,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(
                                    id = selectedPaymentOption?.icon ?: R.drawable.logo_payment
                                ),
                                contentDescription = "Payment Logo",
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            LabelLarge(
                                text = selectedPaymentOption?.name ?: "Pilih Metode Pembayaran",
                                color = TextColors.grey700
                            )
                        }
                        Icon(
                            painter = painterResource(id = if (selectedPaymentOption != null) R.drawable.ic_check_icon else R.drawable.ic_arrow_right),
                            contentDescription = "Icon Status",
                            tint = if (selectedPaymentOption != null) BrandColors.brandPrimary600 else TextColors.grey500
                        )
                    }
                }
                Spacer(modifier = Modifier.height(32.dp))
                CustomButton(text = "Bayar Sekarang", onClick = {
                    isLoading = true
                    bookingViewModel.updatePaymentDetails(
                        sessionId = sessionId,
                        paymentMethod = selectedPaymentOption?.name ?: ""
                    ).addOnCompleteListener {
                        // Ensure a minimum loading duration of 2 seconds
                        val handler = Handler(Looper.getMainLooper())
                        handler.postDelayed({
                            isLoading = false
                            navController.navigate("paymentSuccessScreen") {
                                popUpTo("homeScreen") { inclusive = false }
                            }
                        }, 2000)
                    }
                })

                if (showPaymentMethodSheet) {
                    PaymentMethodBottomSheet(
                        onSubmit = { id, amount ->
                            // Handle submission
                            showPaymentMethodSheet = false
                        },
                        onDismiss = {
                            showPaymentMethodSheet = false
                        },
                        ewalletList = ewalletOptions,
                        bankList = bankOptions,
                        selectedOption = selectedPaymentOption?.id ?: "",
                        onOptionSelected = { id ->
                            // Find the selected payment option from the list of all options
                            val allOptions = ewalletOptions + bankOptions
                            selectedPaymentOption = allOptions.find { it.id == id }
                        }
                    )
                }
            }
        }
    }
}


fun formatDateTime(dateTimeString: String, outputPattern: String = "dd MMM yyyy, HH:mm"): String {
    val inputFormat = SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.getDefault())
    val outputFormat = SimpleDateFormat(outputPattern, Locale.getDefault())
    val date = inputFormat.parse(dateTimeString)
    return outputFormat.format(date)
}

fun formatCurrency(amount: Int): String {
    val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
    return format.format(amount)
}