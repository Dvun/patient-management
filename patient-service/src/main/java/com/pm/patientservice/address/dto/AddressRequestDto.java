package com.pm.patientservice.address.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;


public record AddressRequestDto(
        String street,
        String city,
        String country,
        String phone,

        @Column(name = "postal_code", length = 5, nullable = false)
        @Pattern(regexp = "\\d{5}", message = "Postal code must be exactly 5 digits")
        String postalCode
) { }
