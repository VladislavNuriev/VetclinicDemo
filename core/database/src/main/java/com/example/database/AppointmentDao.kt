package com.example.database

import androidx.room.*
import com.example.database.models.AppointmentEntity

@Dao
interface AppointmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: AppointmentEntity)

    @Query("DELETE FROM appointments WHERE id = :id")
    suspend fun deleteAppointmentById(id: Int)

    @Query("SELECT * FROM appointments WHERE id = :id")
    suspend fun getAppointmentById(id: Int): AppointmentEntity

    @Query("SELECT * FROM appointments WHERE medicalCardId = :medicalCardId ORDER BY dateTime DESC")
    suspend fun getAppointmentsByMedicalCardId(medicalCardId: Int): List<AppointmentEntity>
}