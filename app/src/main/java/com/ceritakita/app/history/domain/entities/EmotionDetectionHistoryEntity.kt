import java.util.Date

data class EmotionDetectionHistoryEntity(
    val userId: String = "",
    val emotionFromImage: String = "",
    val emotionFromText: String = "",
    val issueResult: String = "",
    val storyFromUser: String = "",
    var detectionTime: Date? = null
)