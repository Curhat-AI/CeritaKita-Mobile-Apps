package com.ceritakita.app.history.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsEndWidth
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Icon
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.textfield.CustomOutlinedTextField
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.HeadingSmall
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.TextColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReviewFormBottomSheet(
    onReviewSubmit: (String, Int) -> Unit,
    onDismiss: () -> Unit
) {
    val reviewState = remember { mutableStateOf("") }
    var showBottomSheet by remember { mutableStateOf(true) }
    var rating by remember { mutableIntStateOf(0) }

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
                    .padding(16.dp)
                    .imePadding()
            ) {
                HeadingSmall(text = "Beri Ulasan Kamu")
                Spacer(modifier = Modifier.height(24.dp))
                BodyLarge(text = "Rating")
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    (1..5).forEach { index ->
                        IconButton(onClick = { rating = index }) {
                            Icon(
                                painter = if (index <= rating) painterResource(id = R.drawable.ic_star_icon) else painterResource(
                                    id = R.drawable.ic_star_outline_icon
                                ),
                                contentDescription = if (index <= rating) "Full Star" else "Empty Star",
                                tint = if (index <= rating) AppColors.warningColor else TextColors.grey500,
                                modifier = Modifier.size(28.dp)
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider(thickness = 1.dp, color = TextColors.grey200)
                Spacer(modifier = Modifier.height(16.dp))
                BodyLarge(text = "Tulis Ulasan")
                Spacer(modifier = Modifier.height(10.dp))
                CustomOutlinedTextField(
                    value = reviewState.value,
                    onValueChange = { reviewState.value = it },
                    placeholderText = "Ceritakan pengalaman kamu selama berkonseling..",
                    isSingleLine = false
                )
                Spacer(modifier = Modifier.height(24.dp))
                CustomButton(
                    text = "Kirim Ulasan",
                    onClick = {
                        onReviewSubmit(reviewState.toString(), rating)
                        showBottomSheet = false
                    })
            }
        }
    }
}