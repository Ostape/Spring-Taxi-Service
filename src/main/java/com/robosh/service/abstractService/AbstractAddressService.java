package com.robosh.service.abstractService;

import com.robosh.model.entities.Address;

import java.util.List;

public interface AbstractAddressService {
    List<Address> getAllAddresses();

    Address getAddressById(Long idAddress);
}
