package com.raceco.apii.Service;

import com.raceco.apii.Entity.Address;

public interface AddressService {
    Address addAddress(Address address);
    Address getAddressById(Long addressId);
    void deleteAddress(Long addressId);

}
