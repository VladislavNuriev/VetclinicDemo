package com.example.data.mappers

import com.example.database.models.AppointmentEntity
import com.example.domain.models.Appointment

object AppointmentMapper {
    fun toDomain(entity: AppointmentEntity): Appointment {
        return Appointment(
            id = entity.id,
            medicalCardId = entity.medicalCardId,
            dateTime = entity.dateTime,
            doctorLastName = entity.doctorLastName,
            doctorSpecialization = entity.doctorSpecialization,
            description = entity.description
        )
    }

    fun toEntity(domain: Appointment): AppointmentEntity {
        return AppointmentEntity(
            id = domain.id,
            medicalCardId = domain.medicalCardId,
            dateTime = domain.dateTime,
            doctorLastName = domain.doctorLastName,
            doctorSpecialization = domain.doctorSpecialization,
            description = domain.description
        )
    }
}