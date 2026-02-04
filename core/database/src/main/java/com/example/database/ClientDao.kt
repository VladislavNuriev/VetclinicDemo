package com.example.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.models.ClientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClient(client: ClientEntity)

    @Query("DELETE FROM clients WHERE phone = :phone")
    suspend fun deleteClientByPhone(phone: String)

    @Query("SELECT * FROM clients WHERE phone LIKE '%' || :query || '%' OR lastName LIKE '%' || :query || '%'")
    fun searchClients(query: String): Flow<List<ClientEntity>>

    @Query("SELECT * FROM clients")
    fun getAllClients(): Flow<List<ClientEntity>>
}