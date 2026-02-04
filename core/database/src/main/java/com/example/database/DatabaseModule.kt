package com.example.database

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): VetClinicDatabase {
        return VetClinicDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideClientDao(database: VetClinicDatabase): ClientDao {
        return database.clientDao()
    }

    @Provides
    @Singleton
    fun provideMedicalCardDao(database: VetClinicDatabase): MedicalCardDao {
        return database.medicalCardDao()
    }

    @Provides
    @Singleton
    fun provideAppointmentDao(database: VetClinicDatabase): AppointmentDao {
        return database.appointmentDao()
    }
}
