package com.pm.patientservice.patient.dto;

import com.pm.patientservice.address.dto.AddressResponseDto;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PatientResponseDto {

    private UUID id;
    private String name;
    private String email;
    private AddressResponseDto address;
    private LocalDate dateOfBirth;
    private LocalDateTime created;
    private LocalDateTime updated;

}
