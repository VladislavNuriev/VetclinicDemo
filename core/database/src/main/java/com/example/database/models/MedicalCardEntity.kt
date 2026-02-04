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
    val breed: String? = null,
    val age: Int,
    val gender: String, // пол: "MALE", "FEMALE"
    val color: String? = null,
    val weight: Float? = null,
    val chipNumber: String? = null,
    val nextAppointmentDate: Long? = null, // timestamp ближайшего приема
    val createdAt: Long = System.currentTimeMillis()
)