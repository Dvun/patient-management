package com.pm.patientservice.address;

import com.pm.patientservice.address.dto.AddressRequestDto;
import com.pm.patientservice.address.mapper.AddressMapper;
import com.pm.patientservice.entity.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    public Address createAddress(AddressRequestDto addressRequestDto) {
        return addressRepository.save(addressMapper.fromRequestToEntity(addressRequestDto));
    }

    @Override
    public void updateAddress(Address existAddress, AddressRequestDto addressRequestDto) {
        addressMapper.updateDto(existAddress, addressRequestDto);
    }
}
