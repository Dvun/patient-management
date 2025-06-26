package com.pm.patientservice.address.mapper;

import com.pm.patientservice.address.dto.AddressRequestDto;
import com.pm.patientservice.address.dto.AddressResponseDto;
import com.pm.patientservice.entity.Address;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-26T09:54:06+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressResponseDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        UUID id = null;
        String street = null;
        String city = null;
        String country = null;
        String phone = null;
        String postalCode = null;
        LocalDateTime created = null;
        LocalDateTime updated = null;

        id = address.getId();
        street = address.getStreet();
        city = address.getCity();
        country = address.getCountry();
        phone = address.getPhone();
        postalCode = address.getPostalCode();
        created = address.getCreated();
        updated = address.getUpdated();

        AddressResponseDto addressResponseDto = new AddressResponseDto( id, street, city, country, phone, postalCode, created, updated );

        return addressResponseDto;
    }

    @Override
    public Address toEntity(AddressResponseDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressDto.street() );
        address.setCity( addressDto.city() );
        address.setCountry( addressDto.country() );
        address.setPhone( addressDto.phone() );
        address.setPostalCode( addressDto.postalCode() );
        address.setCreated( addressDto.created() );
        address.setUpdated( addressDto.updated() );

        return address;
    }

    @Override
    public Address fromRequestToEntity(AddressRequestDto addressRequestDto) {
        if ( addressRequestDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setStreet( addressRequestDto.street() );
        address.setCity( addressRequestDto.city() );
        address.setCountry( addressRequestDto.country() );
        address.setPhone( addressRequestDto.phone() );
        address.setPostalCode( addressRequestDto.postalCode() );

        return address;
    }

    @Override
    public void updateDto(Address address, AddressRequestDto addressRequestDto) {
        if ( addressRequestDto == null ) {
            return;
        }

        address.setStreet( addressRequestDto.street() );
        address.setCity( addressRequestDto.city() );
        address.setCountry( addressRequestDto.country() );
        address.setPhone( addressRequestDto.phone() );
        address.setPostalCode( addressRequestDto.postalCode() );
    }
}
