package com.ceritakita.app.counselor.domain.entities

import java.util.Date

data class CounselorScheduleEntity(
    val id: String = "",
    val availableDate: Date? = null,
    val counselorId: String = "",
    val timeSlots: List<TimeSlot> = emptyList()
) {
    data class TimeSlot(
        val bookedBy: String = "",
        val startTime: Date? = null,
        val endTime: Date? = null,
        val status: String = ""
    )
}
