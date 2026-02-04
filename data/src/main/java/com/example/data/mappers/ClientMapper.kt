package com.example.data.mappers

import com.example.database.models.ClientEntity
import com.example.domain.models.Client

object ClientMapper {
    fun toDomain(entity: ClientEntity): Client {
        return Client(
            phone = entity.phone,
            firstName = entity.firstName,
            lastName = entity.lastName,
            medicalCards = emptyList()
        )
    }

    fun toEntity(domain: Client): ClientEntity {
        return ClientEntity(
            phone = domain.phone,
            firstName = domain.firstName,
            lastName = domain.lastName
        )
    }
}