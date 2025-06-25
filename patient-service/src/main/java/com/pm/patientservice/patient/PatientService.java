package com.pm.patientservice.patient;

import com.pm.patientservice.patient.dto.PatientRequestDto;
import com.pm.patientservice.patient.dto.PatientResponseDto;
import java.util.List;
import java.util.UUID;

public interface PatientService {

    List<PatientResponseDto> getAllPatients();
    PatientResponseDto createPatient(PatientRequestDto patientRequestDto);
    PatientResponseDto getPatientById(UUID id);

}
