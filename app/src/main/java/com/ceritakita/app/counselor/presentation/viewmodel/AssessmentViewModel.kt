package com.ceritakita.app.counselor.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceritakita.app.counselor.data.repository.UserPreferenceRepository
import com.ceritakita.app.recognition.presentation.data.remote.CounselourRecommendationRequest
import com.ceritakita.app.recognition.presentation.domain.usecase.RecommendCounselourUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AssessmentViewModel @Inject constructor(
    private val userPreferenceRepository: UserPreferenceRepository,
    private val recommendCounselourUseCase: RecommendCounselourUseCase
) : ViewModel() {
    var currentStep by mutableStateOf(1)
    var servicePreferences = mutableStateListOf<String>()
    var topicPreferences = mutableStateListOf<String>()
    var typePreferences = mutableStateListOf<String>()
    var agePreferences = mutableStateListOf<String>()
    var genderPreference = mutableStateListOf<String>()
    var dayPreferences = mutableStateListOf<String>()
    var timePreferences = mutableStateListOf<String>()

    private val _counselorRecommendations = MutableStateFlow<List<String>>(emptyList())
    val counselorRecommendations: StateFlow<List<String>> get() = _counselorRecommendations

    fun addOrRemovePreference(preference: String, isActive: Boolean, preferencesList: MutableList<String>) {
        if (isActive) {
            if (!preferencesList.contains(preference)) {
                preferencesList.add(preference)
            }
        } else {
            preferencesList.remove(preference)
        }
    }

    fun submitUserPreferences(userId: String) {
        val userPreferences = UserPreferences(
            servicePref = servicePreferences,
            topicPref = topicPreferences,
            typePref = typePreferences,
            agePref = agePreferences,
            genderPref = genderPreference,
            dayPref = dayPreferences,
            timePref = timePreferences
        )
        viewModelScope.launch {
            userPreferenceRepository.setUserPreferences(userId, userPreferences).addOnSuccessListener {
                // Handle success
            }.addOnFailureListener {
                // Handle failure
            }
        }
    }

    fun recommendCounselors(request: CounselourRecommendationRequest) {
        viewModelScope.launch {
            try {
                val result = recommendCounselourUseCase(request)
                _counselorRecommendations.value = result.recommendations
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    fun nextStep(userId: String) {
        if (currentStep < 7) {
            currentStep++
        } else {
            submitUserPreferences(userId)
            val request = CounselourRecommendationRequest(
                gender = genderPreference.firstOrNull() ?: "m",
                counselourType = typePreferences.firstOrNull() ?: "professional",
                dateUp = "2024-06-01",
                dateDown = "2024-06-29",
                timeUp = 20.5,
                timeDown = 18.0
            )
            recommendCounselors(request)
        }
    }

    fun previousStep() {
        if (currentStep > 1) {
            currentStep--
        }
    }
}