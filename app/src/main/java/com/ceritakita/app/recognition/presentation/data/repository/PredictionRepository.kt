package com.ceritakita.app.recognition.presentation.data.repository


import com.ceritakita.app.recognition.presentation.data.remote.ApiService
import com.ceritakita.app.recognition.presentation.data.remote.TextRequest
import okhttp3.MultipartBody
import javax.inject.Inject

class PredictionRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun predictText(text: String): String {
        return apiService.predictText(TextRequest(text))
    }

    suspend fun predictImage(file: MultipartBody.Part): String {
        return apiService.predictImage(file)
    }
}
