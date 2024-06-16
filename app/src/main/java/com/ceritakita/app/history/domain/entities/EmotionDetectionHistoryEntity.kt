import java.util.Date

data class EmotionDetectionHistoryEntity(
    val userId: String = "",
    val emotion: String = "",
    var detectionTime: Date? = null,
    val imageUrl: String = ""
)
