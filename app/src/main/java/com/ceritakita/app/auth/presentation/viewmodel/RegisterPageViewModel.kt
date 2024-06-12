package com.ceritakita.app.auth.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class RegisterPageViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : ViewModel() {

    suspend fun registerUser(nama: String, email: String, password: String) {
        try {
            val user = auth.createUserWithEmailAndPassword(email, password).await().user
            Log.i("data auth", "nama ${nama} | email ${email} | ${password}")
            user?.let {
                val userData = hashMapOf(
                    "displayName" to nama,
                    "email" to email,
                    "roles" to {
                        "counselor" to false
                        "patient" to false
                    },
                    "details" to {
                        "dob" to null
                        "gender" to null
                        "phone" to null
                        "photoUrl" to null
                    }
                )
                firestore.collection("users").document(user.uid).set(userData).await()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
