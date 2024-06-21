package com.ceritakita.app.auth.presentation.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class RegisterPageViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val sharedPreferences: SharedPreferences

) : ViewModel() {
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess
    private val _registerSuccess = MutableLiveData<Boolean>()
    val registerSuccess: LiveData<Boolean> = _registerSuccess
    suspend fun registerUserWithGoogle(account: FirebaseUser) {
        try {
            account?.let { user ->
                val userData: Map<String, Any> = hashMapOf(
                    "displayName" to (user.displayName ?: ""),
                    "email" to (user.email ?: ""),
                    "roles" to mapOf(
                        "counselor" to false,
                        "patient" to true
                    ),
                    "details" to mapOf(
                        "dob" to null,
                        "gender" to null,
                        "phone" to null,
                        "photoUrl" to null
                    )
                )
                saveUserDetailsToSharedPrefd(userData,user.uid)
                firestore.collection("users").document(user.uid).set(userData).await()
                _registerSuccess.postValue(true)

            }
        } catch (e: Exception) {
             _registerSuccess.postValue(false)
            e.printStackTrace()
        }
    }
    private fun saveUserDetailsToSharedPrefd(userData: Map<String, Any>, userId: String) {
        val detailsMap = userData["details"] as? Map<String, Any?>
        sharedPreferences.edit().apply {
            putString("userId", userId)
            putString("displayName", userData["displayName"] as? String)
            putString("email", userData["email"] as? String)
            putBoolean("isCounselor", (userData["roles"] as? Map<String, Boolean>)?.get("counselor") ?: false)
            putBoolean("isPatient", (userData["roles"] as? Map<String, Boolean>)?.get("patient") ?: false)
            putString("dob", detailsMap?.get("dob") as? String)
            putString("gender", detailsMap?.get("gender") as? String)
            putString("phone", detailsMap?.get("phone") as? String)
            putString("photoUrl", detailsMap?.get("photoUrl") as? String)
            apply()
        }
        // Logging the saved values
        Log.i("SharedPreferences", "userId: ${sharedPreferences.getString("userId", "No ID")}")
        Log.i("SharedPreferences", "displayName: ${sharedPreferences.getString("displayName", "No Name")}")
        Log.i("SharedPreferences", "email: ${sharedPreferences.getString("email", "No Email")}")
        Log.i("SharedPreferences", "isCounselor: ${sharedPreferences.getBoolean("isCounselor", false)}")
        Log.i("SharedPreferences", "isPatient: ${sharedPreferences.getBoolean("isPatient", false)}")
        Log.i("SharedPreferences", "dob: ${sharedPreferences.getString("dob", "No DOB")}")
        Log.i("SharedPreferences", "gender: ${sharedPreferences.getString("gender", "No Gender")}")
        Log.i("SharedPreferences", "phone: ${sharedPreferences.getString("phone", "No Phone")}")
        Log.i("SharedPreferences", "photoUrl: ${sharedPreferences.getString("photoUrl", "No Photo")}")
    }

    suspend fun loginUser(email: String, password: String) {
        try {
            val user = auth.signInWithEmailAndPassword(email.trim(), password.trim()).await().user
            user?.let {
                val docRef = firestore.collection("users").document(it.uid)
                val docSnapshot = docRef.get().await()
                if (docSnapshot.exists()) {
                    val userData = docSnapshot.data
                    saveUserDetailsToSharedPref(userData,it.uid)
                }
                _loginSuccess.postValue(true)
            }
        } catch (e: Exception) {
            _loginSuccess.postValue(false)
            Log.e("LoginPageViewModel", "Login failed: ${e.localizedMessage}")
        }
    }

     fun saveUserDetailsToSharedPref(userData: Map<String, Any>?, userId: String) {
        val detailsMap = userData?.get("details") as? Map<String, Any?>
        sharedPreferences.edit().apply {
            putString("userId", userId)
            putString("displayName", userData?.get("displayName") as? String)
            putString("email", userData?.get("email") as? String)
            putBoolean("isCounselor", (userData?.get("roles") as? Map<String, Boolean>)?.get("counselor") ?: false)
            putBoolean("isPatient", (userData?.get("roles") as? Map<String, Boolean>)?.get("patient") ?: false)
            putString("dob", detailsMap?.get("dob") as? String)
            putString("gender", detailsMap?.get("gender") as? String)
            putString("phone", detailsMap?.get("phone") as? String)
            putString("photoUrl", detailsMap?.get("photoUrl") as? String)
            apply()
        }
        // Logging the saved values
        Log.i("SharedPreferences", "userId: ${sharedPreferences.getString("userId", "No ID")}")
        Log.i("SharedPreferences", "displayName: ${sharedPreferences.getString("displayName", "No Name")}")
        Log.i("SharedPreferences", "email: ${sharedPreferences.getString("email", "No Email")}")
        Log.i("SharedPreferences", "isCounselor: ${sharedPreferences.getBoolean("isCounselor", false)}")
        Log.i("SharedPreferences", "isPatient: ${sharedPreferences.getBoolean("isPatient", false)}")
        Log.i("SharedPreferences", "dob: ${sharedPreferences.getString("dob", "No DOB")}")
        Log.i("SharedPreferences", "gender: ${sharedPreferences.getString("gender", "No Gender")}")
        Log.i("SharedPreferences", "phone: ${sharedPreferences.getString("phone", "No Phone")}")
        Log.i("SharedPreferences", "photoUrl: ${sharedPreferences.getString("photoUrl", "No Photo")}")
    }


    suspend fun registerUser(nama: String, email: String, password: String) {
        try {
            val user = auth.createUserWithEmailAndPassword(email.trim(), password.trim()).await().user
            Log.i("data auth", "nama ${nama} | email ${email} | ${password}")
            user?.let {
                val userData = hashMapOf(
                    "displayName" to nama,
                    "email" to email.trim(),
                    "roles" to mapOf(
                        "counselor" to false,
                        "patient" to true
                    ),
                    "details" to mapOf(
                        "dob" to null,
                        "gender" to null,
                        "phone" to null,
                        "photoUrl" to null
                    )
                )
                firestore.collection("users").document(user.uid).set(userData).await()
                loginUser(email,password)
            }
        } catch (e: Exception) {
            _registerSuccess.postValue(false)
            e.printStackTrace()
        }
    }
}
