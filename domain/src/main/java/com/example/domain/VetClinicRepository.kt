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
        fun getMedicalCards(clientPhone: String): Flow<List<MedicalCard>>

        // Appointments
        suspend fun insertAppointment(appointment: Appointment)
        suspend fun deleteAppointment(id: String)
        fun getAppointmentById(id: String): Flow<Appointment?>
        fun getAppointmentsByMedicalCardId(medicalCardId: String): Flow<List<Appointment>>
}