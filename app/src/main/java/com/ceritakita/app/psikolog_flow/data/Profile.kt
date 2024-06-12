package com.ceritakita.app.psikolog_flow.data

data class Profile(
    val name: String,
    val degree: String,
    val expertise: String,
    val imageUrl: String,
    val yearsExperience: Int,
    val rating: Double
)