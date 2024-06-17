package com.ceritakita.app.recognition.presentation.data.remote

import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService {
    @POST("predict/text")
    @Headers("Content-Type: application/json")
    suspend fun predictText(@Body request: TextRequest): TextPredictionResponse

    @Multipart
    @POST("predict/image")
    suspend fun predictImage(@Part file: MultipartBody.Part): ImagePredictionResponse
}


data class TextRequest(
    val text: String
)
data class TextPredictionResponse(
    val predictions: List<String>
)

data class ImagePredictionResponse(
    val predicted_class: List<String>
)
