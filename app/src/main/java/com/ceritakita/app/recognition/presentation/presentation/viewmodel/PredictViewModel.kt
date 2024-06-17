package com.ceritakita.app.recognition.presentation.presentation.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ceritakita.app.recognition.presentation.domain.usecase.PredictImageUseCase
import com.ceritakita.app.recognition.presentation.domain.usecase.PredictTextUseCase
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

    fun predictText(text: String) {
        viewModelScope.launch {
            _predictionStatus.value = PredictionStatus.LOADING
            Log.d("PredictViewModel", "Predicting text...")
            try {
                val result = predictTextUseCase(text)
                Log.d("PredictViewModel", "Received text prediction result: $result")
                _textPrediction.value = result.predictions
                _predictionStatus.value = PredictionStatus.SUCCESS
                Log.d("PredictViewModel", "Text prediction success")
            } catch (e: Exception) {
                Log.e("PredictViewModel", "Text prediction error", e)
                _predictionStatus.value = PredictionStatus.ERROR
            }
        }
    }

    fun predictImage(file: MultipartBody.Part) {
        viewModelScope.launch {
            _predictionStatus.value = PredictionStatus.LOADING
            Log.d("PredictViewModel", "Predicting image...")
            try {
                val result = predictImageUseCase(file)
                Log.d("PredictViewModel", "Received image prediction result: $result")
                _imagePrediction.value = result.predicted_class
                _predictionStatus.value = PredictionStatus.SUCCESS
                Log.d("PredictViewModel", "Image prediction success")
            } catch (e: Exception) {
                Log.e("PredictViewModel", "Image prediction error", e)
                _predictionStatus.value = PredictionStatus.ERROR
            }
        }
    }

    fun clearStatus() {
        _predictionStatus.value = null
    }
}


