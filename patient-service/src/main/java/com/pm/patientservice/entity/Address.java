package com.pm.patientservice.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private UUID id;

    private String street;
    private String city;
    private String country;
    private String phone;

    @Column(name = "postal_code", length = 5, nullable = false)
    @Pattern(regexp = "\\d{5}", message = "Postal code must be exactly 5 digits")
    private String postalCode;

    @CreationTimestamp
    private LocalDateTime created = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime updated;


}
