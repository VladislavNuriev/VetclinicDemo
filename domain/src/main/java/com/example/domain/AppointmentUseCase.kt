package com.example.domain

import com.example.domain.models.Appointment
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAppointmentsByMedicalCardIdUseCase @Inject constructor(
    private val repository: VetClinicRepository
) {
    operator fun invoke(medicalCardId: String): Flow<List<Appointment>> {
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