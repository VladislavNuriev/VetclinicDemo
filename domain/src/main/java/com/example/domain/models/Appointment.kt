package com.example.domain.models

data class Appointment(
    val id: String,
    val medicalCardId: String,
    val dateTime: Long,
    val doctorLastName: String,
    val doctorSpecialization: String,
    val description: String? = null,
)
