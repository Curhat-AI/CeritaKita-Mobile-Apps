package com.ceritakita.app.counselor.presentation.screen

import CustomAppBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import com.ceritakita.app.homepage.presentation.viewmodel.UserViewModel
import com.ceritakita.app.recognition.presentation.data.remote.CounselourRecommendationRequest

@Composable
fun AssessmentFormScreen(
    navController: NavController,
    viewModel: AssessmentViewModel = hiltViewModel(),
) {
    val viewModelUser: UserViewModel = hiltViewModel()
    val userData by viewModelUser.userData.observeAsState()
    val patientId = userData?.userId.toString()

    val step = viewModel.currentStep
    val counselorRecommendations by viewModel.counselorRecommendations.collectAsState()

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
                1 -> StepOne(viewModel = viewModel, onNext = { viewModel.nextStep(userData?.userId ?: "") })
                2 -> StepTwo(viewModel = viewModel, onNext = { viewModel.nextStep(userData?.userId ?: "") }, onBack = { viewModel.previousStep() })
                3 -> StepThree(viewModel = viewModel, onNext = { viewModel.nextStep(userData?.userId ?: "") }, onBack = { viewModel.previousStep() })
                4 -> StepFour(viewModel = viewModel, onNext = { viewModel.nextStep(userData?.userId ?: "") }, onBack = { viewModel.previousStep() })
                5 -> StepFive(viewModel = viewModel, onNext = { viewModel.nextStep(userData?.userId ?: "") }, onBack = { viewModel.previousStep() })
                6 -> StepSix(viewModel = viewModel, onNext = { viewModel.nextStep(userData?.userId ?: "") }, onBack = { viewModel.previousStep() })
                7 -> StepSeven(viewModel = viewModel, onNext = {
                    userData?.let{
                        viewModel.submitUserPreferences(patientId)
                        val request = CounselourRecommendationRequest(
                            gender = viewModel.genderPreference.firstOrNull() ?: "m",
                            counselourType = viewModel.typePreferences.firstOrNull() ?: "professional",
                            dateUp = "2024-06-01",
                            dateDown = "2024-06-29",
                            timeUp = 20.5,
                            timeDown = 18.0
                        )
                        viewModel.recommendCounselors(request)
                    }
                    navController.navigate("counselorListScreen")
                }, onBack = { viewModel.previousStep() })
            }
        }
    }
}