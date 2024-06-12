package com.ceritakita.app.psikolog_flow.presentation.screen

import CustomAppBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.ceritakita.app.psikolog_flow.presentation.component.multistep_form.StepFive
import com.ceritakita.app.psikolog_flow.presentation.component.multistep_form.StepFour
import com.ceritakita.app.psikolog_flow.presentation.component.multistep_form.StepOne
import com.ceritakita.app.psikolog_flow.presentation.component.multistep_form.StepSeven
import com.ceritakita.app.psikolog_flow.presentation.component.multistep_form.StepSix
import com.ceritakita.app.psikolog_flow.presentation.component.multistep_form.StepThree
import com.ceritakita.app.psikolog_flow.presentation.component.multistep_form.StepTwo

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
                2 -> StepTwo(onNext = { step++ }, onBack = { step-- })
                3 -> StepThree(onNext = { step++ }, onBack = { step-- })
                4 -> StepFour(onNext = { step++ }, onBack = { step-- })
                5 -> StepFive(onNext = { step++ }, onBack = { step-- })
                6 -> StepSix(onNext = { step++ }, onBack = { step-- })
                7 -> StepSeven(onNext = { step++ }, onBack = { step-- })
            }
        }
    }
}