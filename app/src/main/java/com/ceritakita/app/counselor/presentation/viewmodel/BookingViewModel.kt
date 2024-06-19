package com.ceritakita.app.counselor.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
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
    ): Task<DocumentReference> {
        _isLoading.value = true
        val bookingData = hashMapOf(
            "counselingDetails" to mapOf(
                "counselorId" to counselorId,
                "patientId" to patientId,
                "startTime" to startTime,
                "endTime" to endTime,
                "communicationPreference" to communicationPreference,
                "counselorFeedback" to "",
                "meetingLink" to "",
                "patientFeedback" to "",
                "rating" to "",
                "status" to "Booked"
            ),
            "paymentDetails" to mapOf(
                "counselingFee" to counselingFee,
                "discount" to 0,
                "paymentDate" to null,
                "paymentStatus" to "Menunggu Pembayaran",
                "tax" to 0,
                "totalPayment" to counselingFee
            ),
            "scheduleId" to scheduleId
        )

        return firestore.collection("counselingSessions")
            .add(bookingData)
            .addOnSuccessListener {
                _isLoading.value = false
            }
            .addOnFailureListener {
                _isLoading.value = false
            }
    }

    fun updatePaymentDetails(
        sessionId: String,
        paymentMethod: String
    ): Task<Void> {
        _isLoading.value = true
        val paymentUpdate = hashMapOf(
            "paymentDetails.paymentMethod" to paymentMethod,
            "paymentDetails.paymentStatus" to "Dibayar",
            "paymentDetails.paymentDate" to FieldValue.serverTimestamp()
        )

        return firestore.collection("counselingSessions")
            .document(sessionId)
            .update(paymentUpdate)
            .addOnSuccessListener {
                _isLoading.value = false
            }
            .addOnFailureListener {
                _isLoading.value = false
            }
    }
}
