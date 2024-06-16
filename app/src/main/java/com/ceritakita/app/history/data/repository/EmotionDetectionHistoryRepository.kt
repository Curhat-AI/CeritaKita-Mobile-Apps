package com.ceritakita.app.history.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class EmotionDetectionHistoryRepository @Inject constructor(private val firestore: FirebaseFirestore) {

    fun getEmotionsByUserId(userId: String): Task<QuerySnapshot> {
        return firestore.collection("emotionDetection")
            .whereEqualTo("userId", userId)
            .get()
    }
}
