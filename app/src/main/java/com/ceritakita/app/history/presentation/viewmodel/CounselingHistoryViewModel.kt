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
        counselingRepository.getCounselingSessionsByPatientId(patientId)
            .addOnSuccessListener { documents ->
                val sessionsList = documents.map { document ->
                    val details = document.get("counselingDetails") as? Map<*, *>
                    CounselingHistoryEntity(
                        sessionId = document.id,
                        counselorId = document.getString("counselorId") ?: "",
                        patientId = document.getString("patientId") ?: "",
                        startTime = document.getDate("startTime"),
                        endTime = document.getDate("endTime"),
                        status = details?.get("status") as? String ?: "Unknown",
                        meetingLink = details?.get("meetingLink") as? String,
                        communicationPreference = details?.get("communicationPreference") as? String,
                        counselorFeedback = details?.get("counselorFeedback") as? String,
                        patientFeedback = details?.get("patientFeedback") as? String,
                        rating = (details?.get("rating") as? Long)?.toInt()
                    )
                }
                _counselingHistories.value = sessionsList
                sessionsList.map { it.counselorId }.distinct().forEach { counselorId ->
                    loadCounselorDetails(counselorId)
                }
            }.addOnFailureListener { exception ->
            // Handle any errors
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