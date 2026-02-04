package com.example.domain

import com.example.domain.models.Appointment
import javax.inject.Inject

class GetAppointmentsByMedicalCardIdUseCase @Inject constructor(
    private val repository: VetClinicRepository
) {
    suspend operator fun invoke(medicalCardId: Int): List<Appointment> {
        return repository.getAppointmentsByMedicalCardId(medicalCardId)
    }
}

class InsertAppointmentUseCase @Inject constructor(
    private val repository: VetClinicRepository
) {
    suspend operator fun invoke(appointment: Appointment) {
        repository.insertAppointment(appointment)
    }
}