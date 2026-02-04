package com.example.domain

import com.example.domain.models.MedicalCard
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetMedCardUseCase @Inject constructor(
    private val repository: VetClinicRepository
) {
    operator fun invoke(phone: String): Flow<List<MedicalCard>> {
        return repository.getMedicalCards(phone)
    }
}

class InsertMedicalCardUseCase @Inject constructor(
    private val repository: VetClinicRepository
) {
    suspend operator fun invoke(medicalCard: MedicalCard) {
        repository.insertMedicalCard(medicalCard)
    }
}

class UpdateMedicalCardUseCase @Inject constructor(
    private val repository: VetClinicRepository
) {
    suspend operator fun invoke(medicalCard: MedicalCard) {
        repository.updateMedicalCard(medicalCard)
    }
}