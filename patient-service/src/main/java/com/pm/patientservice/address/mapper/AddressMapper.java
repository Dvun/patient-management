package com.pm.patientservice.address.mapper;

import com.pm.patientservice.address.dto.AddressRequestDto;
import com.pm.patientservice.address.dto.AddressResponseDto;
import com.pm.patientservice.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressResponseDto toDto(Address address);
    Address toEntity(AddressResponseDto addressDto);
    Address fromRequestToEntity(AddressRequestDto addressRequestDto);
    void updateDto(@MappingTarget Address address, AddressRequestDto addressRequestDto);

}
