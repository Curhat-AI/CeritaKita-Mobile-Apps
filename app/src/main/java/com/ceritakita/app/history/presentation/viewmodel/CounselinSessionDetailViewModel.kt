package com.ceritakita.app.history.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ceritakita.app.counselor.data.repository.CounselorListRepository
import com.ceritakita.app.counselor.domain.entities.CounselorProfileEntities
import com.ceritakita.app.history.data.repository.CounselingHistoryRepository
import com.ceritakita.app.history.domain.entities.CounselingHistoryEntity
import com.google.firebase.firestore.DocumentSnapshot
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CounselingSessionDetailViewModel @Inject constructor(
    private val counselingRepository: CounselingHistoryRepository,
    private val counselorRepository: CounselorListRepository
) : ViewModel() {

    private val _sessionDetail = MutableLiveData<CounselingHistoryEntity?>()
    val sessionDetail: LiveData<CounselingHistoryEntity?> = _sessionDetail

    private val _counselorDetail = MutableLiveData<CounselorProfileEntities?>()
    val counselorDetail: LiveData<CounselorProfileEntities?> = _counselorDetail


    fun loadSessionAndCounselorDetails(sessionId: String) {
        counselingRepository.getSessionById(sessionId).addOnSuccessListener { document ->
            val sessionData = parseCounselingHistoryEntity(document)  // Use the parsing function here

            if (sessionData != null) {
                _sessionDetail.value = sessionData

                // Load counselor details
                sessionData.counselorId?.let { counselorId ->
                    loadCounselorDetails(counselorId)
                }
            } else {
                Log.d("CounselingDetailVM", "Failed to parse session data or session does not exist.")
            }
        }.addOnFailureListener { e ->
            Log.e("CounselingDetailVM", "Error loading session", e)
        }
    }

    private fun loadCounselorDetails(counselorId: String) {
        counselorRepository.getCounselorById(counselorId).addOnSuccessListener { document ->
            val counselorData = parseCounselorProfileEntities(document)  // Use the parsing function here

            if (counselorData != null) {
                _counselorDetail.value = counselorData
            } else {
                Log.d("CounselingDetailVM", "Failed to parse counselor data or counselor does not exist.")
            }
        }.addOnFailureListener { e ->
            Log.e("CounselingDetailVM", "Error loading counselor details", e)
        }
    }


    fun parseCounselingHistoryEntity(document: DocumentSnapshot): CounselingHistoryEntity? {
        val details = document.get("counselingDetails") as? Map<*, *>
        return if (document.exists()) {
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
        } else {
            null
        }
    }

    fun parseCounselorProfileEntities(document: DocumentSnapshot): CounselorProfileEntities? {
        val counselorDetails = document.get("counselorDetails") as? Map<*, *>
        val details = document.get("details") as? Map<*, *>
        val roles = document.get("roles") as? Map<*, *>
        return if (document.exists()) {
            CounselorProfileEntities(
                id = document.id,
                name = counselorDetails?.get("name") as? String ?: "Unknown Counselor",
                bio = counselorDetails?.get("bio") as? String ?: "",
                counselorType = counselorDetails?.get("counselorType") as? String ?: "",
                expertise = counselorDetails?.get("expertise") as? String ?: "",
                experienceYears = (counselorDetails?.get("experienceYears") as? Long)?.toInt() ?: 0,
                imageUrl = details?.get("photoUrl") as? String ?: "",
                dob = details?.get("dob")?.toString() ?: "Unknown DOB",
                gender = details?.get("gender") as? String ?: "Unknown",
                phone = details?.get("phone")?.toString() ?: "Unknown",
                email = document.getString("email") ?: "Unknown",
                counselor = roles?.get("counselor") as? Boolean ?: false,
                patient = roles?.get("patient") as? Boolean ?: false
            )
        } else {
            null
        }
    }

}


