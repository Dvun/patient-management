package com.pm.patientservice.patient;

import com.pm.patientservice.patient.dto.PatientRequestDto;
import com.pm.patientservice.patient.dto.PatientResponseDto;
import com.pm.patientservice.common.exception.EmailAlreadyExistsException;
import com.pm.patientservice.common.exception.NotFoundException;
import com.pm.patientservice.entity.Patient;
import com.pm.patientservice.patient.mapper.PatientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@Transactional
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    @Transactional(readOnly = true)
    public List<PatientResponseDto> getAllPatients() {
        return patientRepository.findAll().stream().map(patientMapper::toDto).toList();
    }

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        if (patientRepository.existsByEmail(patientRequestDto.email())) {
            throw new EmailAlreadyExistsException("A patient with email " + patientRequestDto.email() + " already exists!");
        }
        Patient patient = patientRepository.save(patientMapper.toEntity(patientRequestDto));
        return patientMapper.toDto(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientResponseDto getPatientById(UUID id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Patient with id " + id + " not found!"));
        return patientMapper.toDto(patient);
    }

    @Override
    public PatientResponseDto updatePatient(UUID id, PatientRequestDto request) {
        Patient existPatient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Patient with id " + id + " not found!"));

        if (!existPatient.getEmail().equals(request.email()) && patientRepository.existsByEmail(request.email())) {
            throw new EmailAlreadyExistsException("A patient with email " + request.email() + " already exists!");
        }

        patientMapper.updateEntity(existPatient, request);
        return patientMapper.toDto(existPatient);
    }

}
