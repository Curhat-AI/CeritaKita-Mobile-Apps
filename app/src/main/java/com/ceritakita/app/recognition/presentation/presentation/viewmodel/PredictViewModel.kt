package com.ceritakita.app.recognition.presentation.presentation.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceritakita.app.recognition.presentation.domain.usecase.PredictImageUseCase
import com.ceritakita.app.recognition.presentation.domain.usecase.PredictTextUseCase
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject
enum class PredictionStatus {
    SUCCESS,
    LOADING,
    ERROR
}

@HiltViewModel
class PredictViewModel @Inject constructor(
    private val predictTextUseCase: PredictTextUseCase,
    private val predictImageUseCase: PredictImageUseCase
) : ViewModel() {
    private val _textPrediction = MutableStateFlow<List<String>?>(null)
    val textPrediction: StateFlow<List<String>?> get() = _textPrediction
    private val _imagePrediction = MutableStateFlow<List<String>?>(null)
    val imagePrediction: StateFlow<List<String>?> get() = _imagePrediction
    private val _predictionStatus = MutableStateFlow<PredictionStatus?>(null)
    val predictionStatus: StateFlow<PredictionStatus?> get() = _predictionStatus
    private val _imageUri = MutableStateFlow<String?>(null)
    val imageUri: StateFlow<String?> get() = _imageUri

    fun setImageUri(uri: String) {
        Log.d("PredictViewModel", "Setting imageUri to: $uri")
        _imageUri.value = uri
        Log.d("PredictViewModel", "imageUri is now: ${_imageUri.value}")
    }

    fun predictImage(file: MultipartBody.Part) {
        viewModelScope.launch {
            _predictionStatus.value = PredictionStatus.LOADING
            try {
                val result = predictImageUseCase(file)
                _imagePrediction.value = result.predicted_class
                if (_textPrediction.value != null) {  // Assuming text prediction is done or does not matter
                    _predictionStatus.value = PredictionStatus.SUCCESS
                }
                Log.d("PredictViewModel", "Image prediction success")
            } catch (e: Exception) {
                Log.e("PredictViewModel", "Image prediction error", e)
                _predictionStatus.value = PredictionStatus.ERROR
            }
        }
    }

    fun predictText(text: String) {
        viewModelScope.launch {
            try {
                val result = predictTextUseCase(text)
                _textPrediction.value = result.predictions
                if (_imagePrediction.value != null) {  // Check if image prediction is done
                    _predictionStatus.value = PredictionStatus.SUCCESS
                }
                Log.d("PredictViewModel", "Text prediction success")
            } catch (e: Exception) {
                Log.e("PredictViewModel", "Text prediction error", e)
                _predictionStatus.value = PredictionStatus.ERROR
            }
        }
    }


    fun clearStatus() {
        _predictionStatus.value = null
    }

    fun saveDetectionResults(userId: String, emotionFromText: String?, emotionFromImage: String?, issueResult: String, storyFromUser: String) {
        viewModelScope.launch {
            val detectionData = hashMapOf(
                "userId" to userId,
                "detectionTime" to FieldValue.serverTimestamp(),
                "emotionFromText" to emotionFromText,
                "emotionFromImage" to emotionFromImage,
                "issueResult" to issueResult,
                "storyFromUser" to storyFromUser
            )

            FirebaseFirestore.getInstance().collection("emotionDetection")
                .add(detectionData)
                .addOnSuccessListener { Log.d("PredictViewModel", "Data saved successfully!") }
                .addOnFailureListener { e -> Log.e("PredictViewModel", "Error saving data", e) }
        }
    }

}