package com.pm.patientservice.patient.mapper;

import com.pm.patientservice.address.mapper.AddressMapper;
import com.pm.patientservice.patient.dto.PatientRequestDto;
import com.pm.patientservice.patient.dto.PatientResponseDto;
import com.pm.patientservice.entity.Patient;
import org.mapstruct.*;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = AddressMapper.class)
public interface PatientMapper {

    PatientResponseDto toDto(Patient patient);
    Patient toEntity(PatientRequestDto request);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "created", ignore = true),
            @Mapping(target = "updated", ignore = true),
    })
    @BeanMapping(nullValuePropertyMappingStrategy = IGNORE)
    void updateEntity(@MappingTarget Patient patient, PatientRequestDto request);

}
