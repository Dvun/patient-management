package com.pm.patientservice.address;

import com.pm.patientservice.address.dto.AddressRequestDto;
import com.pm.patientservice.entity.Address;

public interface AddressService {

    Address createAddress(AddressRequestDto addressRequestDto);
    void updateAddress(Address address, AddressRequestDto addressRequestDto);

}
