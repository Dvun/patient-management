package com.pm.patientservice.patient;

import com.pm.patientservice.address.AddressService;
import com.pm.patientservice.address.mapper.AddressMapper;
import com.pm.patientservice.entity.Address;
import com.pm.patientservice.patient.dto.PatientRequestDto;
import com.pm.patientservice.patient.dto.PatientResponseDto;
import com.pm.patientservice.common.exception.EmailAlreadyExistsException;
import com.pm.patientservice.common.exception.NotFoundException;
import com.pm.patientservice.entity.Patient;
import com.pm.patientservice.patient.mapper.PatientMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final AddressService addressService;
    private final PatientMapper patientMapper;
    private final AddressMapper addressMapper;

    @Override
    @Transactional
    public List<PatientResponseDto> getAllPatients() {
        return patientRepository.findAll().stream().map(patientMapper::toDto).toList();
    }

    @Override
    @Transactional
    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        if (patientRepository.existsByEmail(patientRequestDto.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with email " + patientRequestDto.getEmail() + " already exists!");
        }
        Patient patient = patientRepository.save(patientMapper.toEntity(patientRequestDto));
        return patientMapper.toDto(patient);
    }

    @Override
    @Transactional
    public PatientResponseDto getPatientById(UUID id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Patient with id " + id + " not found!"));
        return patientMapper.toDto(patient);
    }

    @Override
    @Transactional
    public PatientResponseDto updatePatient(UUID id, PatientRequestDto request) {
        Patient existPatient = patientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Patient with id " + id + " not found!"));

        if (!existPatient.getEmail().equals(request.getEmail()) && patientRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("A patient with email " + request.getEmail() + " already exists!");
        }

//        if (request.getAddress() != null) {
//            if (existPatient.getAddress() == null) {
//                Address address = addressService.createAddress(request.getAddress());
//                existPatient.setAddress(address);
//            } else {
//                addressService.updateAddress(existPatient.getAddress(), request.getAddress());
//            }
//        }

        patientMapper.updateEntity(existPatient, request);
//        patientRepository.save(existPatient);

        return patientMapper.toDto(existPatient);
    }

}
