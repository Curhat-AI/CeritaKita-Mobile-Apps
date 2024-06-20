package com.ceritakita.app.recognition.presentation.domain.usecase

import com.ceritakita.app.recognition.presentation.data.remote.CounselourRecommendationRequest
import com.ceritakita.app.recognition.presentation.data.remote.CounselourRecommendationResponse
import com.ceritakita.app.recognition.presentation.data.repository.PredictionRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class PredictTextUseCase @Inject constructor(
    private val repository: PredictionRepository
) {
    suspend operator fun invoke(text: String) = repository.predictText(text)
}

class PredictImageUseCase @Inject constructor(
    private val repository: PredictionRepository
) {
    suspend operator fun invoke(file: MultipartBody.Part) = repository.predictImage(file)
}

class PredictMentalIssueUseCase @Inject constructor(
    private val repository: PredictionRepository
) {
    suspend operator fun invoke(text: String) = repository.predictMentalIssue(text)
}

class RecommendCounselourUseCase @Inject constructor(
    private val repository: PredictionRepository
) {
    suspend operator fun invoke(request: CounselourRecommendationRequest): CounselourRecommendationResponse {
        return repository.recommendCounselour(request)
    }
}
