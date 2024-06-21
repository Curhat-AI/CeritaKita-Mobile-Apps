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
    var rating: String? = null,
    var counselingFee: Int = 0,
    var discount: Int = 0,
    var paymentDate: Date? = null,
    var paymentMethod: String? = null,
    var paymentStatus: String? = null,
    var tax: Int = 0,
    var totalPayment: Int = 0,
    var scheduleId: String = ""
)