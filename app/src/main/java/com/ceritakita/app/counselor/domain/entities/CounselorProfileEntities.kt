package com.ceritakita.app.counselor.domain.entities

data class CounselorProfileEntities(
    val name: String,
    val bio: String,
    val counselorType: String,
    val expertise: String,
    val experienceYears: Int,
    val imageUrl: String,
    val dob: String,
    val gender: String,
    val phone: String,
    val email: String,
    val counselor: Boolean,
    val patient: Boolean
)
