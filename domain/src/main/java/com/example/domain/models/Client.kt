package com.example.domain.models

data class Client(
    val phone: String,
    val firstName: String,
    val lastName: String,
    val medicalCards: List<MedicalCard> = emptyList()
)