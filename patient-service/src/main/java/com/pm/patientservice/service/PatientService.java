package com.pm.patientservice.service;

import com.pm.patientservice.dto.patient.PatientRequestDto;
import com.pm.patientservice.dto.patient.PatientResponseDto;
import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientResponseDto> getAllPatients();
    PatientResponseDto createPatient(PatientRequestDto patientRequestDto);
    PatientResponseDto getPatientById(UUID id);

}
