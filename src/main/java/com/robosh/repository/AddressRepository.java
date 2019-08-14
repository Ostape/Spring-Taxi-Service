package com.robosh.repository;

import com.robosh.model.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Integer> {
}
