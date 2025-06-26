package com.pm.patientservice.address.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.util.UUID;

public record AddressResponseDto(
        UUID id,
        String street,
        String city,
        String country,
        String phone,

        @Column(name = "postal_code", length = 5, nullable = false)
        @Pattern(regexp = "\\d{5}", message = "Postal code must be exactly 5 digits")
        String postalCode,
        LocalDateTime created,
        LocalDateTime updated
) { }
