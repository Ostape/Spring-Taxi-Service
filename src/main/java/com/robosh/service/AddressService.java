package com.robosh.service;

import com.robosh.model.entities.Address;
import com.robosh.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public Address getAddressById(Long idAddress) {
        return addressRepository.findByIdAddress(idAddress);
    }
}
