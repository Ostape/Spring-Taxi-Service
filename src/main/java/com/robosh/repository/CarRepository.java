package com.robosh.repository;

import com.robosh.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Address, Long> {
}
