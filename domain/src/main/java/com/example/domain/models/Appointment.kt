package com.example.domain.models

data class Appointment(
    val id: Int,
    val medicalCardId: Int,
    val dateTime: Long,
    val doctorLastName: String,
    val doctorSpecialization: String,
    val description: String = "",
)
