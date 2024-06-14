package com.ceritakita.app.counselor.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ceritakita.app.counselor.data.repository.CounselorListRepository
import com.ceritakita.app.counselor.domain.entities.CounselorProfileEntities
import dagger.hilt.android.lifecycle.HiltViewModel
import java.text.SimpleDateFormat
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class CounselorListViewModel @Inject constructor(private val repository: CounselorListRepository) :
    ViewModel() {

    private val _profiles = MutableLiveData<List<CounselorProfileEntities>>()
    val profiles: LiveData<List<CounselorProfileEntities>> = _profiles
    private val _selectedCounselor = MutableLiveData<CounselorProfileEntities>() // Use the complete entity
    val selectedCounselor: LiveData<CounselorProfileEntities> = _selectedCounselor
    init {
        loadProfiles()
    }

    private fun loadProfiles() {
        repository.getPsychologists().addOnSuccessListener { documents ->
//            Log.d("CounselorViewModel", "Successfully fetched documents: ${documents.size()} entries")

            val profilesList = documents.map { document ->
//                Log.d("CounselorViewModel", "Document Data: ${document.data}")
                val profile = CounselorProfileEntities(
                    id = document.id,
                    name = document.getString("counselorDetails.name") ?: "Unknown",
                    bio = document.getString("counselorDetails.bio") ?: "No Bio",
                    counselorType = document.getString("counselorDetails.counselorType")
                        ?: "No Type",
                    expertise = document.getString("counselorDetails.expertise") ?: "No Expertise",
                    experienceYears = document.getLong("counselorDetails.experienceYears")?.toInt()
                        ?: 0,
                    imageUrl = document.getString("details.photoUrl") ?: "No Image",
                    dob = document.getTimestamp("details.dob")?.let {
                        SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(it.toDate())
                    } ?: "No DOB",
                    gender = document.getString("details.gender") ?: "No Gender",
                    phone = document.getLong("details.phone")?.toString() ?: "No Phone",
                    email = document.getString("email") ?: "No Email",
                    counselor = document.getBoolean("roles.counselor") ?: false,
                    patient = document.getBoolean("roles.patient") ?: false
                )
//                Log.d("CounselorViewModel", "Constructed Profile: $profile")
                profile
            }

            _profiles.value = profilesList
//            Log.d("CounselorViewModel", "Profiles loaded: ${profilesList.size}")
        }.addOnFailureListener { exception ->
            Log.e("CounselorViewModel", "Error loading profiles", exception)
        }
    }

    fun getCounselorDetails(counselorId: String) {
        repository.getCounselorById(counselorId)
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val counselorData = document.toObject(CounselorProfileEntities::class.java)?.apply {
                        this.id = document.id
                    }
                    counselorData?.let {
                        _selectedCounselor.value = it
                        Log.d("CounselorViewModel", "Counselor details loaded: $it")
                    } ?: Log.w("CounselorViewModel", "Failed to deserialize document")
                } else {
                    Log.d("CounselorViewModel", "No document found for counselorId: $counselorId")
                }
            }
            .addOnFailureListener { exception ->
                Log.e("CounselorViewModel", "Error fetching counselor details", exception)
            }
    }

}
