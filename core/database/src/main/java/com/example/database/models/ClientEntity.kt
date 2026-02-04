package com.example.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clients")
data class ClientEntity(
    @PrimaryKey
    val phone: String,
    val firstName: String,
    val lastName: String
)
