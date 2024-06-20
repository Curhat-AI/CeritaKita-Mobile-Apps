package com.ceritakita.app.counselor.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ceritakita.app.counselor.data.repository.UserPreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserPreferenceViewModel @Inject constructor(
    private val userPreferenceRepository: UserPreferenceRepository
) : ViewModel() {
    private val _status = MutableLiveData<String>()
    val status: LiveData<String> get() = _status

    fun submitUserPreferences(userId: String, preferences: UserPreferences) {
        userPreferenceRepository.setUserPreferences(userId, preferences)
            .addOnSuccessListener {
                _status.value = "Preferences Updated Successfully"
            }
            .addOnFailureListener { e ->
                _status.value = "Error updating preferences: ${e.message}"
            }
    }
}

data class UserPreferences(
    val servicePref: List<String>,
    val topicPref: List<String>,
    val typePref: List<String>,
    val agePref: List<String>,
    val genderPref: List<String>,
    val dayPref: List<String>,
    val timePref: List<String>
)