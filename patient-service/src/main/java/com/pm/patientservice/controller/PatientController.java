package com.pm.patientservice.controller;

import com.pm.patientservice.dto.patient.PatientRequestDto;
import com.pm.patientservice.dto.patient.PatientResponseDto;
import com.pm.patientservice.service.PatientService;
import com.pm.patientservice.utils.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/patient")
@RestController
@Validated
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<PatientResponseDto>>> getAllPatients() {
        return ResponseEntity.ok(ApiResponse.success(patientService.getAllPatients()));
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<PatientResponseDto>> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto) {
        return ResponseEntity.ok().body(ApiResponse.success(patientService.createPatient(patientRequestDto)));
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse<PatientResponseDto>> getPatientById(@PathVariable UUID id) {
        return ResponseEntity.ok(ApiResponse.success(patientService.getPatientById(id)));
    }

}
