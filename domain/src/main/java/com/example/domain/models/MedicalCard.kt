package com.example.domain.models

data class MedicalCard(
    val id: String,
    val owner: Client,
    val petName: String,
    val species: String,
    val age: Int,
    val appointments: List<Appointment> = emptyList()
)