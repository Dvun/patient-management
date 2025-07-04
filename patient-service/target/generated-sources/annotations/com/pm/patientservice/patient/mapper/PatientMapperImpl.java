package com.pm.patientservice.patient.mapper;

import com.pm.patientservice.address.dto.AddressRequestDto;
import com.pm.patientservice.address.dto.AddressResponseDto;
import com.pm.patientservice.address.mapper.AddressMapper;
import com.pm.patientservice.entity.Address;
import com.pm.patientservice.entity.Patient;
import com.pm.patientservice.patient.dto.PatientRequestDto;
import com.pm.patientservice.patient.dto.PatientResponseDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-04T23:40:00+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
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

        UUID id = null;
        String name = null;
        String email = null;
        AddressResponseDto address = null;
        LocalDate dateOfBirth = null;
        LocalDateTime created = null;
        LocalDateTime updated = null;

        id = patient.getId();
        name = patient.getName();
        email = patient.getEmail();
        address = addressMapper.toDto( patient.getAddress() );
        dateOfBirth = patient.getDateOfBirth();
        created = patient.getCreated();
        updated = patient.getUpdated();

        PatientResponseDto patientResponseDto = new PatientResponseDto( id, name, email, address, dateOfBirth, created, updated );

        return patientResponseDto;
    }

    @Override
    public Patient toEntity(PatientRequestDto request) {
        if ( request == null ) {
            return null;
        }

        Patient patient = new Patient();

        patient.setName( request.name() );
        patient.setEmail( request.email() );
        patient.setDateOfBirth( request.dateOfBirth() );
        patient.setRegisteredDate( request.registeredDate() );
        patient.setAddress( addressMapper.fromRequestToEntity( request.address() ) );

        return patient;
    }

    @Override
    public PatientResponseDto fromRequestToResponseDto(PatientRequestDto request) {
        if ( request == null ) {
            return null;
        }

        String name = null;
        String email = null;
        AddressResponseDto address = null;
        LocalDate dateOfBirth = null;

        name = request.name();
        email = request.email();
        address = addressMapper.toDto( addressMapper.fromRequestToEntity( request.address() ) );
        dateOfBirth = request.dateOfBirth();

        UUID id = null;
        LocalDateTime created = null;
        LocalDateTime updated = null;

        PatientResponseDto patientResponseDto = new PatientResponseDto( id, name, email, address, dateOfBirth, created, updated );

        return patientResponseDto;
    }

    @Override
    public PatientRequestDto fromResponseToRequestDto(PatientResponseDto response) {
        if ( response == null ) {
            return null;
        }

        String name = null;
        String email = null;
        AddressRequestDto address = null;
        LocalDate dateOfBirth = null;

        name = response.name();
        email = response.email();
        address = addressResponseDtoToAddressRequestDto( response.address() );
        dateOfBirth = response.dateOfBirth();

        LocalDate registeredDate = null;

        PatientRequestDto patientRequestDto = new PatientRequestDto( name, email, address, dateOfBirth, registeredDate );

        return patientRequestDto;
    }

    @Override
    public void updateEntity(Patient patient, PatientRequestDto request) {
        if ( request == null ) {
            return;
        }

        if ( request.name() != null ) {
            patient.setName( request.name() );
        }
        if ( request.email() != null ) {
            patient.setEmail( request.email() );
        }
        if ( request.dateOfBirth() != null ) {
            patient.setDateOfBirth( request.dateOfBirth() );
        }
        if ( request.registeredDate() != null ) {
            patient.setRegisteredDate( request.registeredDate() );
        }
        if ( request.address() != null ) {
            if ( patient.getAddress() == null ) {
                patient.setAddress( new Address() );
            }
            addressMapper.updateDto( patient.getAddress(), request.address() );
        }
    }

    protected AddressRequestDto addressResponseDtoToAddressRequestDto(AddressResponseDto addressResponseDto) {
        if ( addressResponseDto == null ) {
            return null;
        }

        String street = null;
        String city = null;
        String country = null;
        String phone = null;
        String postalCode = null;

        street = addressResponseDto.street();
        city = addressResponseDto.city();
        country = addressResponseDto.country();
        phone = addressResponseDto.phone();
        postalCode = addressResponseDto.postalCode();

        AddressRequestDto addressRequestDto = new AddressRequestDto( street, city, country, phone, postalCode );

        return addressRequestDto;
    }
}
