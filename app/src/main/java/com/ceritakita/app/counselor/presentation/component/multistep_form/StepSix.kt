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
import com.ceritakita.app.counselor.presentation.component.AssessmentButtonComponent
import com.ceritakita.app.counselor.presentation.component.ButtonType
import com.ceritakita.app.counselor.presentation.component.CheckboxComponent

@Composable
fun StepSix(onNext: () -> Unit, onBack: () -> Unit) {
    var senin by remember { mutableStateOf(false) }
    var selasa by remember { mutableStateOf(false) }
    var rabu by remember { mutableStateOf(false) }
    var kamis by remember { mutableStateOf(false) }
    var jumat by remember { mutableStateOf(false) }
    var sabtu by remember { mutableStateOf(false) }
    var minggu by remember { mutableStateOf(false) }

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
                onCheckedChange = { senin = it }
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
                onCheckedChange = { selasa = it }
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
                onCheckedChange = { rabu = it }
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
                onCheckedChange = { kamis = it }
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
                onCheckedChange = { jumat = it }
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
                onCheckedChange = { sabtu = it }
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
                onCheckedChange = { minggu = it }
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