package com.robosh.service;

import com.robosh.model.entities.Address;
import com.robosh.repository.AddressRepository;
import com.robosh.service.abstractService.AbstractAddressService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements AbstractAddressService {
    private final Logger logger = LogManager.getLogger(ClientService.class);
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(final AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddresses() {
        logger.info("get all addresses");
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(final Long idAddress) {
        logger.info("get address by id: " + idAddress);
        return addressRepository.findByIdAddress(idAddress);
    }
}
