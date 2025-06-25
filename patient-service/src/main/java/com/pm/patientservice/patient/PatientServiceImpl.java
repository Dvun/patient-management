package com.pm.patientservice.patient;

import com.pm.patientservice.patient.dto.PatientRequestDto;
import com.pm.patientservice.patient.dto.PatientResponseDto;
import com.pm.patientservice.common.exception.EmailAlreadyExistsException;
import com.pm.patientservice.common.exception.NotFoundException;
import com.pm.patientservice.patient.mapper.PatientMapper;
import com.pm.patientservice.entity.Patient;
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
