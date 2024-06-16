package com.ceritakita.app.counselor.data.repository

import android.util.Log
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class CounselorListRepository @Inject constructor(private val firestore: FirebaseFirestore) {
    fun getPsychologists(): Task<QuerySnapshot> {
        Log.d("CounselorListRepository", "Fetching all psychologists from psikolog-db")
        return firestore.collection("psikolog-db").get().addOnSuccessListener {
            Log.d("CounselorListRepository", "Successfully fetched ${it.size()} psychologists")
        }.addOnFailureListener { e ->
            Log.e("CounselorListRepository", "Failed to fetch psychologists", e)
        }
    }

    fun getCounselorById(id: String): Task<DocumentSnapshot> {
        Log.d("CounselorListRepository", "Preparing to fetch details for counselor ID: $id")
        return firestore.collection("psikolog-db").document(id).get().addOnSuccessListener {
            if (it.exists()) {
                Log.d("CounselorListRepository", "Successfully fetched details for counselor ID: $id")
            } else {
                Log.d("CounselorListRepository", "Document with ID: $id does not exist.")
            }
        }.addOnFailureListener { e ->
            Log.e("CounselorListRepository", "Failed to fetch counselor details for ID: $id", e)
        }
    }

}