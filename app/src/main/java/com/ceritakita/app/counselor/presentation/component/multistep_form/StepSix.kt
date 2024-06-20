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
fun StepSix(viewModel: AssessmentViewModel, onNext: () -> Unit, onBack: () -> Unit) {
    val senin = viewModel.dayPreferences.contains("Senin")
    val selasa = viewModel.dayPreferences.contains("Selasa")
    val rabu = viewModel.dayPreferences.contains("Rabu")
    val kamis = viewModel.dayPreferences.contains("Kamis")
    val jumat = viewModel.dayPreferences.contains("Jumat")
    val sabtu = viewModel.dayPreferences.contains("Sabtu")
    val minggu = viewModel.dayPreferences.contains("Minggu")

    Column(modifier = Modifier.padding(16.dp)) {
        TitleLarge("Lebih prefer cerita dihari apa?")
        Spacer(modifier = Modifier.height(4.dp))
        BodyLarge(text = "Pilih salah satu atau lebih")
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = senin,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Senin", isActive, viewModel.dayPreferences) }
            )
            BodyLarge(
                "Senin",
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
                checked = selasa,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Selasa", isActive, viewModel.dayPreferences) }
            )
            BodyLarge(
                "Selasa",
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
                checked = rabu,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Rabu", isActive, viewModel.dayPreferences) }
            )
            BodyLarge(
                "Rabu",
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
                checked = kamis,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Kamis", isActive, viewModel.dayPreferences) }
            )
            BodyLarge(
                "Kamis",
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
                checked = jumat,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Jumat", isActive, viewModel.dayPreferences) }
            )
            BodyLarge(
                "Jumat",
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
                checked = sabtu,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Sabtu", isActive, viewModel.dayPreferences) }
            )
            BodyLarge(
                "Sabtu",
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
                checked = minggu,
                onCheckedChange = { isActive -> viewModel.addOrRemovePreference("Minggu", isActive, viewModel.dayPreferences) }
            )
            BodyLarge(
                "Minggu", modifier = Modifier.padding(start = 8.dp),
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
                enabled = senin || selasa || rabu || kamis || jumat || sabtu || minggu,
                modifier = Modifier.weight(1f)
            )
        }
    }
}