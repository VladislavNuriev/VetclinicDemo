package com.example.database.models

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "appointments",
    foreignKeys = [
        ForeignKey(
            entity = MedicalCardEntity::class,
            parentColumns = ["id"],
            childColumns = ["medicalCardId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
)
data class AppointmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val medicalCardId: Int,
    val dateTime: Long,
    val doctorLastName: String,
    val doctorSpecialization: String,
    val description: String = "",
)
