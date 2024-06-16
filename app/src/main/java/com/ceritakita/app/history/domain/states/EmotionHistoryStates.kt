package com.ceritakita.app.history.domain.states

import EmotionDetectionHistoryEntity

sealed class EmotionHistoryState {
    object Loading : EmotionHistoryState()
    data class Success(val data: List<EmotionDetectionHistoryEntity>) : EmotionHistoryState()
    data class Error(val message: String) : EmotionHistoryState()
}
