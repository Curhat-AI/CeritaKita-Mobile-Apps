package com.ceritakita.app.recognition.presentation.data.remote

import com.google.gson.annotations.SerializedName
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

    @POST("predict/mental-issue")
    @Headers("Content-Type: application/json")
    suspend fun predictMentalIssue(@Body request: MentalIssueRequest): MentalIssuePredictionResponse

    @POST("recommendation/counselour")
    @Headers("Content-Type: application/json")
    suspend fun recommendCounselour(@Body request: CounselourRecommendationRequest): CounselourRecommendationResponse
}

data class TextRequest(
    val text: String
)
data class TextPredictionResponse(
    val predictions: List<String>
)

data class MentalIssueRequest(
    val text: String
)

data class MentalIssuePredictionResponse(
    val predictions: List<String>
)

data class ImagePredictionResponse(
    val predicted_class: List<String>
)

data class CounselourRecommendationRequest(
    val gender: String,
    val counselourType: String,
    val dateUp: String,
    val dateDown: String,
    val timeUp: Double,
    val timeDown: Double
)

data class CounselourRecommendationResponse(
    @SerializedName("id_counselor_recommendation") val recommendations: List<String>
)
