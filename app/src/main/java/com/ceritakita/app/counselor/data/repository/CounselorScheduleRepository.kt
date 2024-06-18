package com.ceritakita.app.counselor.data.repository

import android.util.Log
import com.ceritakita.app.counselor.domain.entities.CounselorScheduleEntity
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class CounselorScheduleRepository @Inject constructor(private val firestore: FirebaseFirestore) {

    fun getCounselorSchedulesByCounselorId(counselorId: String): Task<QuerySnapshot> {
        Log.d("CounselorScheduleRepo", "Fetching schedules for counselor ID: $counselorId")
        return firestore.collection("counselorSchedule")
            .whereEqualTo("counselorId", counselorId)
            .get()
    }

    fun parseCounselorScheduleEntity(document: DocumentSnapshot): CounselorScheduleEntity {
        val timeSlots = document.get("timeSlots") as? List<Map<String, Any>> ?: emptyList()
        val parsedTimeSlots = timeSlots.map { timeSlot ->
            CounselorScheduleEntity.TimeSlot(
                bookedBy = timeSlot["bookedBy"] as? String ?: "",
                startTime = (timeSlot["startTime"] as? com.google.firebase.Timestamp)?.toDate(),
                endTime = (timeSlot["endTime"] as? com.google.firebase.Timestamp)?.toDate(),
                status = timeSlot["status"] as? String ?: ""
            )
        }
        val scheduleEntity = CounselorScheduleEntity(
            id = document.id,
            availableDate = (document.get("availableDate") as? com.google.firebase.Timestamp)?.toDate(),
            counselorId = document.getString("counselorId") ?: "",
            timeSlots = parsedTimeSlots
        )
        Log.d("CounselorScheduleRepo", "Parsed schedule entity: $scheduleEntity")
        return scheduleEntity
    }
}