package com.ceritakita.app.history.presentation.viewmodel

import EmotionDetectionHistoryEntity
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ceritakita.app.history.data.repository.EmotionDetectionHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EmotionDetectionHistoryViewModel @Inject constructor(
    private val repository: EmotionDetectionHistoryRepository
) : ViewModel() {

    private val _emotionHistories = MutableLiveData<List<EmotionDetectionHistoryEntity>>()
    val emotionHistories: LiveData<List<EmotionDetectionHistoryEntity>> = _emotionHistories

    fun loadEmotionHistories(userId: String) {
        repository.getEmotionsByUserId(userId).addOnSuccessListener { documents ->
            if (documents.isEmpty()) {
                Log.d("EmotionDetectionHistoryVM", "No documents found for user ID: $userId")
            } else {
                Log.d("EmotionDetectionHistoryVM", "Documents fetched: ${documents.size()}")
                documents.forEach { doc ->
                    Log.d("EmotionDetectionHistoryVM", "Document data: ${doc.data}")
                }
            }
            val emotionsList = documents.map { document ->
                EmotionDetectionHistoryEntity(
                    userId = document.getString("userId") ?: "Unknown",
                    emotion = document.getString("emotion") ?: "No emotion",
                    detectionTime = document.getDate("detectionTime"),
                    imageUrl = document.getString("imageUrl") ?: "No image URL"
                )
            }
            _emotionHistories.value = emotionsList
        }.addOnFailureListener { exception ->
            Log.e("EmotionDetectionHistoryVM", "Error loading documents: ", exception)
            // Handle errors, possibly updating the UI to show an error message
        }
    }
}