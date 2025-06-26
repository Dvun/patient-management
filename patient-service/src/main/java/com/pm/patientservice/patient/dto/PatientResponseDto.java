package com.pm.patientservice.patient.dto;

import com.pm.patientservice.address.dto.AddressResponseDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


public record PatientResponseDto (

    UUID id,
    String name,
    String email,
    AddressResponseDto address,
    LocalDate dateOfBirth,
    LocalDateTime created,
    LocalDateTime updated
) {}
