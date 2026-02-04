package com.example.database

import androidx.room.*
import com.example.database.models.MedicalCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicalCardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMedicalCard(medicalCard: MedicalCardEntity)

    @Update
    suspend fun updateMedicalCard(medicalCard: MedicalCardEntity)

    @Query("SELECT * FROM medical_cards WHERE ownerPhone = :clientPhone")
    fun getMedicalCardsByClient(clientPhone: String): Flow<List<MedicalCardEntity>>
}