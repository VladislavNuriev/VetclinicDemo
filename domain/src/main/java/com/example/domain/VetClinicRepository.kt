package com.example.domain

import com.example.domain.models.Appointment
import com.example.domain.models.Client
import com.example.domain.models.MedicalCard
import kotlinx.coroutines.flow.Flow

interface VetClinicRepository {

        // Clients
        suspend fun insertClient(client: Client)
        suspend fun deleteClient(phone: String)
        fun searchClient(query: String): Flow<List<Client>>
        fun getAllClients(): Flow<List<Client>>

        // Medical cards
        suspend fun insertMedicalCard(medicalCard: MedicalCard)
        suspend fun updateMedicalCard(medicalCard: MedicalCard)
        suspend fun getMedicalCards(clientPhone: String): Result<List<MedicalCard>>

        // Appointments
        suspend fun insertAppointment(appointment: Appointment)
        suspend fun deleteAppointment(id: Int)
        suspend fun getAppointmentById(id: Int): Appointment
        suspend fun getAppointmentsByMedicalCardId(medicalCardId: Int): List<Appointment>
}