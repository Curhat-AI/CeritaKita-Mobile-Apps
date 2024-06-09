package com.ceritakita.app.psikolog_flow.presentation.component.multistep_form

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.psikolog_flow.presentation.component.AssessmentButtonComponent
import com.ceritakita.app.psikolog_flow.presentation.component.ButtonType
import com.ceritakita.app.psikolog_flow.presentation.component.CheckboxComponent

@Composable
fun StepFour(onNext: () -> Unit, onBack: () -> Unit) {
    var youngAdults_18_24 by remember { mutableStateOf(false) }
    var youngAdults_25_34 by remember { mutableStateOf(false) }
    var middleAged_35_44 by remember { mutableStateOf(false) }
    var middleAged_45_54 by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        TitleLarge("Preferensi umur partner cerita")
        Spacer(modifier = Modifier.height(4.dp))
        BodyLarge(text = "Pilih salah satu atau lebih")
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.padding(bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = youngAdults_18_24,
                onCheckedChange = { youngAdults_18_24 = it }
            )
            BodyLarge(
                "18-24 tahun",
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
                checked = youngAdults_25_34,
                onCheckedChange = { youngAdults_25_34 = it }
            )
            BodyLarge(
                "25-34 tahun", modifier = Modifier.padding(start = 8.dp),
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
                checked = middleAged_35_44,
                onCheckedChange = { middleAged_35_44 = it }
            )
            BodyLarge(
                "35-44 tahun",
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
                checked = middleAged_45_54,
                onCheckedChange = { middleAged_45_54 = it }
            )
            BodyLarge(
                "45-54 tahun",
                modifier = Modifier.padding(start = 8.dp),
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
                enabled = youngAdults_18_24 || youngAdults_25_34 || middleAged_35_44 || middleAged_45_54,
                modifier = Modifier.weight(1f)
            )
        }
    }
}