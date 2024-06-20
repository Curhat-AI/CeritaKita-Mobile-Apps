package com.ceritakita.app.counselor.presentation.screen

import CustomAppBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ceritakita.app.counselor.presentation.component.multistep_form.StepFive
import com.ceritakita.app.counselor.presentation.component.multistep_form.StepFour
import com.ceritakita.app.counselor.presentation.component.multistep_form.StepOne
import com.ceritakita.app.counselor.presentation.component.multistep_form.StepSeven
import com.ceritakita.app.counselor.presentation.component.multistep_form.StepSix
import com.ceritakita.app.counselor.presentation.component.multistep_form.StepThree
import com.ceritakita.app.counselor.presentation.component.multistep_form.StepTwo
import com.ceritakita.app.counselor.presentation.viewmodel.AssessmentViewModel

@Composable
fun AssessmentFormScreen(
    navController: NavController,
    viewModel: AssessmentViewModel = hiltViewModel()
) {
    val step by remember { mutableStateOf(viewModel.currentStep) }
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
                1 -> StepOne(viewModel = viewModel, onNext = { viewModel.nextStep() })
                2 -> StepTwo(viewModel = viewModel, onNext = { viewModel.nextStep() }, onBack = { viewModel.previousStep() })
                3 -> StepThree(viewModel = viewModel, onNext = { viewModel.nextStep() }, onBack = { viewModel.previousStep() })
                4 -> StepFour(viewModel = viewModel, onNext = { viewModel.nextStep() }, onBack = { viewModel.previousStep() })
                5 -> StepFive(viewModel = viewModel, onNext = { viewModel.nextStep() }, onBack = { viewModel.previousStep() })
                6 -> StepSix(viewModel = viewModel, onNext = { viewModel.nextStep() }, onBack = { viewModel.previousStep() })
                7 -> StepSeven(viewModel = viewModel, onNext = {
                    viewModel.submitUserPreferences("userId") // Replace "userId" with actual user ID
                    navController.navigate("nextScreen") // Replace with actual navigation target
                }, onBack = { viewModel.previousStep() })
            }
        }
    }
}
