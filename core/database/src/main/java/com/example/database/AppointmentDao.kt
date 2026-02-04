package com.example.database

import androidx.room.*
import com.example.database.models.AppointmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppointmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: AppointmentEntity)

    @Query("DELETE FROM appointments WHERE id = :id")
    suspend fun deleteAppointmentById(id: String)

    @Query("SELECT * FROM appointments WHERE id = :id")
    fun getAppointmentById(id: String): Flow<AppointmentEntity?>

    @Query("SELECT * FROM appointments WHERE medicalCardId = :medicalCardId ORDER BY dateTime DESC")
    fun getAppointmentsByMedicalCardId(medicalCardId: String): Flow<List<AppointmentEntity>>
}