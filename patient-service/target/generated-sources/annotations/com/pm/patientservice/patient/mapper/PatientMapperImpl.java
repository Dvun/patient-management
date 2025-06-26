package com.pm.patientservice.patient.mapper;

import com.pm.patientservice.address.mapper.AddressMapper;
import com.pm.patientservice.entity.Address;
import com.pm.patientservice.entity.Patient;
import com.pm.patientservice.patient.dto.PatientRequestDto;
import com.pm.patientservice.patient.dto.PatientResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-26T09:45:46+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class PatientMapperImpl implements PatientMapper {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public PatientResponseDto toDto(Patient patient) {
        if ( patient == null ) {
            return null;
        }

        PatientResponseDto patientResponseDto = new PatientResponseDto();

        patientResponseDto.setId( patient.getId() );
        patientResponseDto.setName( patient.getName() );
        patientResponseDto.setEmail( patient.getEmail() );
        patientResponseDto.setAddress( addressMapper.toDto( patient.getAddress() ) );
        patientResponseDto.setDateOfBirth( patient.getDateOfBirth() );
        patientResponseDto.setCreated( patient.getCreated() );
        patientResponseDto.setUpdated( patient.getUpdated() );

        return patientResponseDto;
    }

    @Override
    public Patient toEntity(PatientRequestDto request) {
        if ( request == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setName( request.getName() );
        patient.setEmail( request.getEmail() );
        patient.setDateOfBirth( request.getDateOfBirth() );
        patient.setRegisteredDate( request.getRegisteredDate() );
        patient.setAddress( addressMapper.fromRequestToEntity( request.getAddress() ) );

        return patient;
    }

    @Override
    public void updateEntity(Patient patient, PatientRequestDto request) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            patient.setName( request.getName() );
        }
        if ( request.getEmail() != null ) {
            patient.setEmail( request.getEmail() );
        }
        if ( request.getDateOfBirth() != null ) {
            patient.setDateOfBirth( request.getDateOfBirth() );
        }
        if ( request.getRegisteredDate() != null ) {
            patient.setRegisteredDate( request.getRegisteredDate() );
        }
        if ( request.getAddress() != null ) {
            if ( patient.getAddress() == null ) {
                patient.setAddress( new Address() );
            }
            addressMapper.updateDto( patient.getAddress(), request.getAddress() );
        }
    }
}
