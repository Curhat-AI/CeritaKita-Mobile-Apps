package com.ceritakita.app.recognition.presentation.data.repository


import com.ceritakita.app.recognition.presentation.data.remote.ApiService
import com.ceritakita.app.recognition.presentation.data.remote.ImagePredictionResponse
import com.ceritakita.app.recognition.presentation.data.remote.MentalIssuePredictionResponse
import com.ceritakita.app.recognition.presentation.data.remote.MentalIssueRequest
import com.ceritakita.app.recognition.presentation.data.remote.TextPredictionResponse
import com.ceritakita.app.recognition.presentation.data.remote.TextRequest
import okhttp3.MultipartBody
import javax.inject.Inject

class PredictionRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun predictText(text: String): TextPredictionResponse {
        return apiService.predictText(TextRequest(text))
    }

    suspend fun predictImage(file: MultipartBody.Part): ImagePredictionResponse {
        return apiService.predictImage(file)
    }

    suspend fun predictMentalIssue(text: String): MentalIssuePredictionResponse {
        return apiService.predictMentalIssue(MentalIssueRequest(text))
    }
}

