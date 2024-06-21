package com.ceritakita.app.homepage.presentation.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val _userData = MutableLiveData<UserData>()
    val userData: LiveData<UserData> = _userData

    init {
        loadUserData()
    }

    private fun loadUserData() {
        val userId = sharedPreferences.getString("userId", null)
        val displayName = sharedPreferences.getString("displayName", null)
        val email = sharedPreferences.getString("email", null)
        val isCounselor = sharedPreferences.getBoolean("isCounselor", false)
        val isPatient = sharedPreferences.getBoolean("isPatient", false)
        val dob = sharedPreferences.getString("dob", null)
        val gender = sharedPreferences.getString("gender", null)
        val phone = sharedPreferences.getString("phone", null)
        val photoUrl = sharedPreferences.getString("photoUrl", null)

        val userData = UserData(
            userId = userId,
            displayName = displayName,
            email = email,
            isCounselor = isCounselor,
            isPatient = isPatient,
            dob = dob,
            gender = gender,
            phone = phone,
            photoUrl = photoUrl
        )

        Log.d("UserViewModel", "Loaded User Data: $userData")
        Log.d("UserViewModel", "User Photo URL: $photoUrl")

        _userData.postValue(userData)
    }

}

data class UserData(
    val userId: String?,
    val displayName: String?,
    val email: String?,
    val isCounselor: Boolean,
    val isPatient: Boolean,
    val dob: String?,
    val gender: String?,
    val phone: String?,
    val photoUrl: String?
)