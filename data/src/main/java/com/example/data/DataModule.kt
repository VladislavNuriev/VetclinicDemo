package com.example.data

import com.example.domain.VetClinicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    @Singleton
    fun bindVetClinicRepository(repositoryImpl: VetClinicRepositoryImpl): VetClinicRepository
}