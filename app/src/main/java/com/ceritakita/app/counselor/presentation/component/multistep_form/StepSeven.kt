package com.ceritakita.app.counselor.presentation.component.multistep_form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.counselor.presentation.component.AssessmentButtonComponent
import com.ceritakita.app.counselor.presentation.component.ButtonType
import com.ceritakita.app.counselor.presentation.component.CheckboxComponent
import com.ceritakita.app.counselor.presentation.viewmodel.AssessmentViewModel

@Composable
fun StepSeven(viewModel: AssessmentViewModel, onNext: () -> Unit, onBack: () -> Unit) {
    val pagi = viewModel.timePreferences.contains("Pagi")
    val siang = viewModel.timePreferences.contains("Siang")
    val sore = viewModel.timePreferences.contains("Sore")
    val malam = viewModel.timePreferences.contains("Malam")

    Column(modifier = Modifier.padding(16.dp)) {
        TitleLarge("Lebih prefer cerita kapan?")
        Spacer(modifier = Modifier.height(4.dp))
        BodyLarge(text = "Pilih salah satu atau lebih")
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = pagi,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Pagi", isActive, viewModel.timePreferences) }
            )
            BodyLarge(
                "Pagi",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = siang,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Siang", isActive, viewModel.timePreferences) }
            )
            BodyLarge(
                "Siang",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = sore,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Sore", isActive, viewModel.timePreferences) }
            )
            BodyLarge(
                "Sore",
                modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }

        Row(
            modifier = Modifier.padding(bottom = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = malam,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Malam", isActive, viewModel.timePreferences) }
            )
            BodyLarge(
                "Malam", modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AssessmentButtonComponent(
                text = "Kembali",
                onClick = onBack,
                buttonType = ButtonType.Secondary,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            AssessmentButtonComponent(
                text = "Selanjutnya",
                onClick = onNext,
                buttonType = ButtonType.Primary,
                enabled = pagi || siang || sore || malam,
                modifier = Modifier.weight(1f)
            )
        }
    }
}