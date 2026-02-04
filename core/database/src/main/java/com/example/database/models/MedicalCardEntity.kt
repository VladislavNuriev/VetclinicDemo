package com.example.database.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "medical_cards",
    foreignKeys = [
        ForeignKey(
            entity = ClientEntity::class,
            parentColumns = ["phone"],
            childColumns = ["ownerPhone"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class MedicalCardEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val ownerPhone: String,
    val petName: String,
    val species: String,
    val age: Int,
)