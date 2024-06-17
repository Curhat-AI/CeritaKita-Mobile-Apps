package com.ceritakita.app.history.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class CounselingHistoryRepository @Inject constructor(private val firestore: FirebaseFirestore) {

    fun getCounselingSessionsByPatientId(patientId: String): Task<QuerySnapshot> {
        return firestore.collection("counselingSessions")
            .whereEqualTo("patientId", patientId)
            .get()
    }
}