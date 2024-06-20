package com.ceritakita.app.recognition.presentation.presentation.screens.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.ui.theme.AppColors
import com.ceritakita.app._core.presentation.ui.theme.BrandColors
import com.ceritakita.app.recognition.presentation.presentation.viewmodel.PredictionStatus

@Composable
fun StatusDialog(status: PredictionStatus?, onDismiss: () -> Unit) {
    if (status != null) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            buttons = {
                when (status) {
                    PredictionStatus.LOADING -> LoadingContent()
                    PredictionStatus.SUCCESS -> SuccessContent()
                    PredictionStatus.ERROR -> ErrorContent()
                }
            },
            modifier = Modifier
                .padding(0.dp)
                .aspectRatio(1f),
        )
    }
}

@Composable
fun LoadingContent() {
    Box(
        modifier = Modifier
            .aspectRatio(1f),
        contentAlignment = Alignment.CenterEnd
    ) {
        Column(
            modifier = Modifier
                .background(BrandColors.brandPrimary50)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CircularProgressIndicator(color = Color.Blue, strokeWidth = 4.dp)
            BodyLarge(
                text = "Sedang menganalisa ceritamu..",
                textAlign = TextAlign.Center,
                color = BrandColors.brandPrimary600
            )
        }
    }
}

@Composable
fun SuccessContent() {
    Box(
        modifier = Modifier
            .aspectRatio(1f),
        contentAlignment = Alignment.CenterEnd
    ) {
        Column(
            modifier = Modifier
                .background(BrandColors.brandPrimary50)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_check_icon),
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .size(32.dp),
                tint = BrandColors.brandPrimary600
            )
            Spacer(modifier = Modifier.height(4.dp))
            BodyLarge(
                text = "Analisa berhasil!",
                textAlign = TextAlign.Center,
                color = BrandColors.brandPrimary600
            )
        }
    }
}

@Composable
fun ErrorContent() {
    Box(
        modifier = Modifier
            .aspectRatio(1f),
        contentAlignment = Alignment.CenterEnd
    ) {
        Column(
            modifier = Modifier
                .background(AppColors.errorColor.copy(alpha = 0.2f))
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_warning_icon),
                contentDescription = "Profile Icon",
                modifier = Modifier
                    .size(32.dp),
                tint = AppColors.errorColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            BodyLarge(
                text = "Terjadi kesalahan",
                textAlign = TextAlign.Center,
                color = AppColors.errorColor
            )
        }
    }
}

@Composable
fun IconContent(icon: Int, contentDescription: String) {
    Box(
        modifier = Modifier
            .size(200.dp),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = contentDescription,
            modifier = Modifier.size(100.dp),
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true, name = "Status Dialog - Loading")
@Composable
fun PreviewStatusDialogLoading() {
    StatusDialog(status = PredictionStatus.LOADING, onDismiss = {})
}

@Preview(showBackground = true, name = "Status Dialog - Success")
@Composable
fun PreviewStatusDialogSuccess() {
    StatusDialog(status = PredictionStatus.SUCCESS, onDismiss = {})
}

@Preview(showBackground = true, name = "Status Dialog - Error")
@Composable
fun PreviewStatusDialogError() {
    StatusDialog(status = PredictionStatus.ERROR, onDismiss = {})
}