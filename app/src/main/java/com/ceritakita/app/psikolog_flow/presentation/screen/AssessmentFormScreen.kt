package com.ceritakita.app.psikolog_flow.presentation.screen

import CustomAppBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ceritakita.app._core.presentation.components.buttons.CustomButton
import com.ceritakita.app._core.presentation.components.texts.BodyLarge
import com.ceritakita.app._core.presentation.components.texts.TitleLarge
import com.ceritakita.app._core.presentation.ui.theme.TextColors
import com.ceritakita.app.psikolog_flow.presentation.component.CheckboxComponent

@Composable
fun AssessmentFormScreen(
    navController: NavController
) {
    var step by remember { mutableIntStateOf(1) }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            CustomAppBar(
                title = "Preferensi Konseling",
                onBackClicked = { navController.navigateUp() }
            )

        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
        ) {
            when (step) {
                1 -> StepOne(onNext = { step++ })
            }
        }

    }
}

@Composable
fun StepOne(onNext: () -> Unit) {
    var mentoring by remember { mutableStateOf(false) }
    var counseling by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        TitleLarge("Apa jenis layanan yang kamu butuhkan?")
        Spacer(modifier = Modifier.height(4.dp))
        BodyLarge(text = "Pilih salah satu atau lebih")
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CheckboxComponent(
                checked = mentoring,
                onCheckedChange = { mentoring = it }
            )
            BodyLarge(
                "Mentoring",
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
                checked = counseling,
                onCheckedChange = { counseling = it }
            )
            BodyLarge(
                "Konseling", modifier = Modifier.padding(start = 8.dp),
                fontSize = 17.sp,
                fontWeight = FontWeight.Medium,
                color = TextColors.grey800
            )
        }
        CustomButton(text = "Selanjutnya", onClick = onNext, enabled = mentoring || counseling)
    }
}