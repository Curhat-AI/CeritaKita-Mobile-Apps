package com.ceritakita.app.counselor.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class CounselorListRepository @Inject constructor(private val firestore: FirebaseFirestore) {
    fun getPsychologists(): Task<QuerySnapshot> {
        return firestore.collection("psikolog-db").get()
    }
}