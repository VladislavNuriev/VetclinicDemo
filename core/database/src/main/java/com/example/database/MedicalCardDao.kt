package com.example.database

import androidx.room.*
import com.example.database.models.MedicalCardEntity

@Dao
interface MedicalCardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicalCard(medicalCard: MedicalCardEntity)

    @Update
    suspend fun updateMedicalCard(medicalCard: MedicalCardEntity)

    @Query("SELECT * FROM medical_cards WHERE ownerPhone = :clientPhone")
    suspend fun getMedicalCardsByClient(clientPhone: String): List<MedicalCardEntity>
}