package com.ceritakita.app.counselor.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ceritakita.app.counselor.data.repository.CounselorScheduleRepository
import com.ceritakita.app.counselor.domain.entities.CounselorScheduleEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CounselorScheduleViewModel @Inject constructor(
    private val repository: CounselorScheduleRepository
) : ViewModel() {

    private val _schedules = MutableLiveData<List<CounselorScheduleEntity>>()
    val schedules: LiveData<List<CounselorScheduleEntity>> = _schedules

    fun loadSchedules(counselorId: String) {
        Log.d("CounselorScheduleVM", "Loading schedules for counselor ID: $counselorId")
        repository.getCounselorSchedulesByCounselorId(counselorId).addOnSuccessListener { documents ->
            Log.d("CounselorScheduleVM", "Fetched ${documents.size()} documents")
            val scheduleList = documents.mapNotNull { document ->
                Log.d("CounselorScheduleVM", "Processing document ${document.id}")
                repository.parseCounselorScheduleEntity(document).also {
                    Log.d("CounselorScheduleVM", "Processed schedule: $it")
                }
            }
            _schedules.value = scheduleList.filter { it.timeSlots.any { slot -> slot.status == "Tersedia" } }
            Log.d("CounselorScheduleVM", "Schedules loaded: ${_schedules.value?.size}")
        }.addOnFailureListener { e ->
            Log.e("CounselorScheduleVM", "Error loading schedules", e)
        }
    }

}