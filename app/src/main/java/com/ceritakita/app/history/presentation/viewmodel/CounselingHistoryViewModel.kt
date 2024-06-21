package com.ceritakita.app.history.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ceritakita.app.counselor.data.repository.CounselorListRepository
import com.ceritakita.app.counselor.domain.entities.CounselorProfileEntities
import com.ceritakita.app.history.data.repository.CounselingHistoryRepository
import com.ceritakita.app.history.domain.entities.CounselingHistoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CounselingHistoryViewModel @Inject constructor(
    private val counselingRepository: CounselingHistoryRepository,
    private val counselorRepository: CounselorListRepository
) : ViewModel() {

    private val _counselingHistories = MutableLiveData<List<CounselingHistoryEntity>>()
    val counselingHistories: LiveData<List<CounselingHistoryEntity>> = _counselingHistories

    private val _counselors = MutableLiveData<Map<String, CounselorProfileEntities>>()
    val counselors: LiveData<Map<String, CounselorProfileEntities>> = _counselors

    fun loadCounselingHistories(patientId: String) {
        Log.d("CounselingHistoryVM", "Loading counseling histories for patientId: $patientId")
        counselingRepository.getCounselingSessionsByPatientId(patientId)
            .addOnSuccessListener { documents ->
                val sessionsList = documents.map { document ->
                    Log.d("CounselingHistoryVM", "Document: ${document.data}")

                    val counselingDetails = document.get("counselingDetails") as? Map<*, *>
                    val paymentDetails = document.get("paymentDetails") as? Map<*, *>

                    val historyEntity = CounselingHistoryEntity(
                        sessionId = document.id,
                        counselorId = counselingDetails?.get("counselorId") as? String ?: "",
                        patientId = counselingDetails?.get("patientId") as? String ?: "",
                        startTime = counselingDetails?.get("startTime") as? Date,
                        endTime = counselingDetails?.get("endTime") as? Date,
                        status = counselingDetails?.get("status") as? String ?: "Unknown",
                        meetingLink = counselingDetails?.get("meetingLink") as? String,
                        communicationPreference = counselingDetails?.get("communicationPreference") as? String,
                        counselorFeedback = counselingDetails?.get("counselorFeedback") as? String,
                        patientFeedback = counselingDetails?.get("patientFeedback") as? String,
                        rating = (counselingDetails?.get("rating") as? String)?.toIntOrNull().toString(),
                        counselingFee = (paymentDetails?.get("counselingFee") as? Long)?.toInt() ?: 0,
                        discount = (paymentDetails?.get("discount") as? Long)?.toInt() ?: 0,
                        paymentDate = paymentDetails?.get("paymentDate") as? Date,
                        paymentMethod = paymentDetails?.get("paymentMethod") as? String,
                        paymentStatus = paymentDetails?.get("paymentStatus") as? String,
                        tax = (paymentDetails?.get("tax") as? Long)?.toInt() ?: 0,
                        totalPayment = (paymentDetails?.get("totalPayment") as? Long)?.toInt() ?: 0,
                        scheduleId = document.getString("scheduleId") ?: ""
                    )

                    Log.d("CounselingHistoryVM", "Parsed History Entity: $historyEntity")
                    historyEntity
                }
                _counselingHistories.value = sessionsList
                Log.d("CounselingHistoryVM", "Sessions List: $sessionsList")

                sessionsList.map { it.counselorId }.distinct().forEach { counselorId ->
                    loadCounselorDetails(counselorId)
                }
            }.addOnFailureListener { exception ->
                Log.e("CounselingHistoryVM", "Error fetching counseling sessions", exception)
            }
    }



    private fun loadCounselorDetails(counselorId: String) {
        counselorRepository.getCounselorById(counselorId).addOnSuccessListener { document ->
            if (document.exists()) {
                val counselorData = CounselorProfileEntities(
                    id = document.id,
                    name = document.getString("counselorDetails.name") ?: "Unknown Counselor",
                    bio = document.getString("counselorDetails.bio") ?: "",
                    counselorType = document.getString("counselorDetails.counselorType") ?: "",
                    expertise = document.getString("counselorDetails.expertise") ?: "",
                    experienceYears = document.getLong("counselorDetails.experienceYears")?.toInt() ?: 0,
                    imageUrl = document.getString("details.photoUrl") ?: "",
                    dob = document.getTimestamp("details.dob")?.toDate()?.let {
                        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(it)
                    } ?: "Unknown DOB",
                    gender = document.getString("details.gender") ?: "Unknown",
                    phone = document.getLong("details.phone")?.toString() ?: "Unknown",
                    email = document.getString("email") ?: "Unknown",
                    counselor = document.getBoolean("roles.counselor") ?: false,
                    patient = document.getBoolean("roles.patient") ?: false
                )
                _counselors.value = _counselors.value?.toMutableMap()?.apply {
                    put(counselorId, counselorData)
                } ?: mapOf(counselorId to counselorData)
            }
        }.addOnFailureListener { e ->
            Log.e("CounselingHistoryVM", "Failed to fetch counselor details for ID: $counselorId", e)
        }
    }
}