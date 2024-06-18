package com.ceritakita.app.counselor.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun bookCounselingSession(
        counselorId: String,
        patientId: String,
        scheduleId: String,
        startTime: Date,
        endTime: Date,
        communicationPreference: String,
        counselingFee: Int
    ) {
        viewModelScope.launch {
            _isLoading.value = true
            val bookingData = hashMapOf(
                "counselorId" to counselorId,
                "patientId" to patientId,
                "scheduleId" to scheduleId,
                "startTime" to startTime,
                "endTime" to endTime,
                "counselingDetails" to mapOf(
                    "communicationPreference" to communicationPreference,
                    "counselorFeedback" to "",
                    "meetingLink" to "",
                    "patientFeedback" to "",
                    "rating" to null,
                    "status" to "Booked"
                ),
                "paymentDetails" to mapOf(
                    "counselingFee" to counselingFee,
                    "discount" to 0,
                    "paymentDate" to null,
                    "paymentStatus" to "Menunggu Dibayar",
                    "tax" to 0,
                    "totalPayment" to counselingFee
                )
            )

            firestore.collection("counselingSessions")
                .add(bookingData)
                .addOnSuccessListener {
                    _isLoading.value = false
                }
                .addOnFailureListener {
                    _isLoading.value = false
                }
        }
    }
}
