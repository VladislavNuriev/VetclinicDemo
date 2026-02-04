package com.example.domain

import com.example.domain.models.MedicalCard
import javax.inject.Inject


class GetMedCardUseCase @Inject constructor(
    private val repository: VetClinicRepository
) {
    suspend operator fun invoke(phone: String): Result<List<MedicalCard>> {
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