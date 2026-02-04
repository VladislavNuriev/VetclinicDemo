package com.example.domain

import com.example.domain.models.Client
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchClient @Inject constructor(
    private val repository: VetClinicRepository
) {
    operator fun invoke(query: String): Flow<List<Client>> {
        return repository.searchClient(query)
    }
}

class InsertClientUseCase @Inject constructor(
    private val repository: VetClinicRepository
) {
    suspend operator fun invoke(patient: Client) {
        repository.insertClient(patient)
    }
}