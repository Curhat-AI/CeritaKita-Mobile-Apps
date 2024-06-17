package com.ceritakita.app.history.domain.entities

import java.util.Date

data class CounselingHistoryEntity(
    var sessionId: String = "",
    var counselorId: String = "",
    var patientId: String = "",
    var startTime: Date? = null,
    var endTime: Date? = null,
    var status: String = "",
    var meetingLink: String? = null,
    var communicationPreference: String? = null,
    var counselorFeedback: String? = null,
    var patientFeedback: String? = null,
    var rating: Int? = null
)

