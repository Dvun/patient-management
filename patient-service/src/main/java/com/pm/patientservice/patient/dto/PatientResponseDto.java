package com.pm.patientservice.patient.dto;

import com.pm.patientservice.entity.Address;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class PatientResponseDto {

    private UUID id;
    private String name;
    private String email;
    private Address address;
    private LocalDate dateOfBirth;
    private LocalDateTime created;
    private LocalDateTime updated;

}
