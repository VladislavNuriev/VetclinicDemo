package com.example.data

import com.example.data.mappers.AppointmentMapper
import com.example.data.mappers.ClientMapper
import com.example.data.mappers.MedicalCardMapper
import com.example.database.AppointmentDao
import com.example.database.ClientDao
import com.example.database.MedicalCardDao
import com.example.domain.VetClinicRepository
import com.example.domain.models.Appointment
import com.example.domain.models.Client
import com.example.domain.models.MedicalCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class VetClinicRepositoryImpl @Inject constructor(
    private val clientDao: ClientDao,
    private val medicalCardDao: MedicalCardDao,
    private val appointmentDao: AppointmentDao
) : VetClinicRepository {

    // Clients
    override suspend fun insertClient(client: Client) {
        clientDao.insertClient(ClientMapper.toEntity(client))
    }

    override suspend fun deleteClient(phone: String) {
        clientDao.deleteClientByPhone(phone)
    }

    override fun searchClient(query: String): Flow<List<Client>> {
        return clientDao.searchClients(query).map { clientEntities ->
            clientEntities.map { clientEntity ->
                ClientMapper.toDomain(clientEntity)
            }
        }
    }

    override fun getAllClients(): Flow<List<Client>> {
        return clientDao.getAllClients().map { clientEntities ->
            clientEntities.map { clientEntity ->
                ClientMapper.toDomain(clientEntity)
            }
        }
    }

    // Medical Cards
    override suspend fun insertMedicalCard(medicalCard: MedicalCard) {
        medicalCardDao.insertMedicalCard(MedicalCardMapper.toEntity(medicalCard))
    }

    override suspend fun updateMedicalCard(medicalCard: MedicalCard) {
        medicalCardDao.updateMedicalCard(MedicalCardMapper.toEntity(medicalCard))
    }

    override suspend fun getMedicalCards(clientPhone: String): Result<List<MedicalCard>> {
        return withContext(Dispatchers.IO) {
            runCatching {
                medicalCardDao.getMedicalCardsByClient(clientPhone)
                    .map { medicalCardEntity ->
                        val appointments = appointmentDao
                            .getAppointmentsByMedicalCardId(medicalCardEntity.id)
                            .map(AppointmentMapper::toDomain)

                        MedicalCardMapper.toDomain(medicalCardEntity, appointments)
                    }
            }
        }
    }


    // Appointments
    override suspend fun insertAppointment(appointment: Appointment) {
        appointmentDao.insertAppointment(AppointmentMapper.toEntity(appointment))
    }

    override suspend fun deleteAppointment(id: Int) {
        appointmentDao.deleteAppointmentById(id)
    }

    override suspend fun getAppointmentById(id: Int): Appointment {
        return withContext(Dispatchers.IO) {
            AppointmentMapper.toDomain(appointmentDao.getAppointmentById(id))
        }
    }

    override suspend fun getAppointmentsByMedicalCardId(medicalCardId: Int): List<Appointment> {
        return withContext(Dispatchers.IO) {
            appointmentDao.getAppointmentsByMedicalCardId(medicalCardId)
                .map {
                    AppointmentMapper.toDomain(it)
                }
        }
    }
}