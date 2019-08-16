package com.robosh.repository;

import com.robosh.model.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;


//todo integer -> long
public interface DriverRepository extends JpaRepository<Driver, Integer> {
}
