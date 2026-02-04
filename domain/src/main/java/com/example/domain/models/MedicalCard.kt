package com.example.domain.models

data class MedicalCard(
    val id: Int,
    val ownerPhone: String,
    val petName: String,
    val species: String,
    val age: Int,
    val appointments: List<Appointment> = emptyList()
)