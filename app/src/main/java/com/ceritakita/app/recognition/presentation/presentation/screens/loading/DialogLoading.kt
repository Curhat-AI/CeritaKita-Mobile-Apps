package com.ceritakita.app.recognition.presentation.presentation.screens.loading

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ceritakita.app.R
import com.ceritakita.app.recognition.presentation.presentation.viewmodel.PredictionStatus

@Composable
fun StatusDialog(status: PredictionStatus?, onDismiss: () -> Unit) {
    if (status != null) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            buttons = {},
            text = {
                when (status) {
                    PredictionStatus.LOADING -> LoadingContent()
                    PredictionStatus.SUCCESS -> SuccessContent()
                    PredictionStatus.ERROR -> ErrorContent()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        )
    }
}

@Composable
fun LoadingContent() {
    IconContent(
        icon = R.drawable.ic_star_icon, // Replace with your loading icon
        contentDescription = "Loading Icon"
    )
}

@Composable
fun SuccessContent() {
    IconContent(
        icon = R.drawable.ic_nav_scan, // Replace with your success icon
        contentDescription = "Success Icon"
    )
}

@Composable
fun ErrorContent() {
    IconContent(
        icon = R.drawable.ic_check_icon, // Replace with your error icon
        contentDescription = "Error Icon"
    )
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
