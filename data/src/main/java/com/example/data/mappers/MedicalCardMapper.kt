package com.example.data.mappers

import com.example.database.models.MedicalCardEntity
import com.example.domain.models.Appointment
import com.example.domain.models.MedicalCard

object MedicalCardMapper {
    fun toDomain(
        entity: MedicalCardEntity,
        appointments: List<Appointment> = emptyList()
    ): MedicalCard {
        return MedicalCard(
            id = entity.id,
            ownerPhone = entity.ownerPhone,
            petName = entity.petName,
            species = entity.species,
            age = entity.age,
            appointments = appointments
        )
    }

    fun toEntity(domain: MedicalCard): MedicalCardEntity {
        return MedicalCardEntity(
            id = domain.id,
            ownerPhone = domain.ownerPhone,
            petName = domain.petName,
            species = domain.species,
            age = domain.age
        )
    }
}