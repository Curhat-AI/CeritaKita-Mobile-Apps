package com.ceritakita.app.counselor.data.repository

import com.ceritakita.app.counselor.presentation.viewmodel.UserPreferences
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import javax.inject.Inject

class UserPreferenceRepository @Inject constructor(private val db: FirebaseFirestore) {
    fun setUserPreferences(userId: String, preferences: UserPreferences): Task<Void> {
        return db.collection("users").document(userId)
            .set(mapOf("userPreferences" to preferences), SetOptions.merge())
    }
}
