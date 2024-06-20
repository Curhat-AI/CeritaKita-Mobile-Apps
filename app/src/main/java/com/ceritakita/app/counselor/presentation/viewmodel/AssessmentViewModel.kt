package com.ceritakita.app.counselor.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AssessmentViewModel @Inject constructor(
    private val userPreferenceViewModel: UserPreferenceViewModel
) : ViewModel() {
    var currentStep by mutableStateOf(1)
    var servicePreferences = mutableStateListOf<String>()
    var topicPreferences = mutableStateListOf<String>()
    var typePreferences = mutableStateListOf<String>()
    var agePreferences = mutableStateListOf<String>()
    var genderPreference = mutableStateListOf<String>()
    var dayPreferences = mutableStateListOf<String>()
    var timePreferences = mutableStateListOf<String>()

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
            userPreferenceViewModel.submitUserPreferences(userId, userPreferences)
        }
    }

    fun nextStep() {
        if (currentStep < 7) {
            currentStep++
        } else {
            // Modify this to use the correct user ID from user authentication or another source
            submitUserPreferences("userId")
        }
    }

    fun previousStep() {
        if (currentStep > 1) {
            currentStep--
        }
    }
}
