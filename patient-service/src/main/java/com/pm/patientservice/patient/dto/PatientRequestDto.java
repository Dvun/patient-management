package com.pm.patientservice.patient.dto;

import com.pm.patientservice.address.dto.AddressRequestDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequestDto {

    @NotBlank(message = "Name cannot be blank!")
    @Size(max = 100, message = "Name cannot exceed 100 characters!")
    private String name;

    @NotBlank(message = "Email is required!")
    @Email(message = "Email should be valid!")
    private String email;

    private AddressRequestDto address;

    @NotNull(message = "Date of birth is required!")
    private LocalDate dateOfBirth;

    @NotNull(message = "Register date is required!")
    private LocalDate registeredDate;

}
