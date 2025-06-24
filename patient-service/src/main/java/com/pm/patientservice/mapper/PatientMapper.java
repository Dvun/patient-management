package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.patient.PatientRequestDto;
import com.pm.patientservice.dto.patient.PatientResponseDto;
import com.pm.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient) {
        PatientResponseDto dto = new PatientResponseDto();
        dto.setId(String.valueOf(patient.getId()));
        dto.setName(patient.getName());
        dto.setAddress(patient.getAddress());
        dto.setEmail(patient.getEmail());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setCreated(patient.getCreated());
        dto.setUpdated(patient.getUpdated());
        return dto;
    }

    public static Patient toEntity(PatientRequestDto dto) {
        Patient patient = new Patient();
        patient.setName(dto.getName());
        patient.setAddress(dto.getAddress());
        patient.setEmail(dto.getEmail());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setRegisteredDate(dto.getRegisteredDate());
        return patient;
    }

}
