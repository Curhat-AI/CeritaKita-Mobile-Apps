package com.ceritakita.app.counselor.domain.entities

data class CounselorProfileEntities(
    var id: String = "",
    var name: String = "",
    var bio: String = "",
    var counselorType: String = "",
    var expertise: String = "",
    var experienceYears: Int = 0,
    var imageUrl: String = "",
    var dob: String = "",
    var gender: String = "",
    var phone: String = "",
    var email: String = "",
    var counselor: Boolean = true,
    var patient: Boolean = false
)
