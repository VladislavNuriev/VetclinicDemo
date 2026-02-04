package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.database.models.AppointmentEntity
import com.example.database.models.ClientEntity
import com.example.database.models.MedicalCardEntity

@Database(
    entities = [AppointmentEntity::class, ClientEntity::class, MedicalCardEntity::class],
    version = 1,
    exportSchema = false
)
abstract class VetClinicDatabase : RoomDatabase() {
    abstract fun clientDao(): ClientDao
    abstract fun medicalCardDao(): MedicalCardDao
    abstract fun appointmentDao(): AppointmentDao

    companion object {
        private var instance: VetClinicDatabase? = null
        private val LOCK = Any()

        fun getInstance(context: Context): VetClinicDatabase {
            instance?.let {
                return it
            }
            synchronized(LOCK) {
                instance?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    context,
                    VetClinicDatabase::class.java,
                    "clinic.db"
                )
                    .fallbackToDestructiveMigration(dropAllTables = true)
                    .build()
                instance = db
                return db
            }
        }
    }
}