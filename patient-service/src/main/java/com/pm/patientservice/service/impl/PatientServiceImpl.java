package com.pm.patientservice.service.impl;

import com.pm.patientservice.dto.patient.PatientRequestDto;
import com.pm.patientservice.dto.patient.PatientResponseDto;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.NotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import com.pm.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public List<PatientResponseDto> getAllPatients() {
        return patientRepository.findAll().stream().map(PatientMapper::toDto).toList();
    }

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        if (patientRepository.existsByEmail(patientRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with email " + patientRequestDto.getEmail() + " already exists!");
        }
        Patient patient = patientRepository.save(PatientMapper.toEntity(patientRequestDto));
        return PatientMapper.toDto(patient);
    }

    @Override
    public PatientResponseDto getPatientById(UUID id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Patient with id " + id + " not found!"));
        return PatientMapper.toDto(patient);
    }

}
