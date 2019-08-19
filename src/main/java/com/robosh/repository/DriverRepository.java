package com.robosh.repository;

import com.robosh.model.entities.Driver;
import com.robosh.model.enums.DriverStatus;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


//todo integer -> long
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByPhoneNumberAndPassword(String phoneNumber, String password);
    Driver findByPhoneNumber(String phoneNumber);

    @Query(value = "select person.name, person.surname, person.person_id," +
            " person.active, person.password, person.phone_number, person.driver_status, person.middle_name, person.id_car, person.role from person " +
            " join car on person.id_car = car.id_car " +
            " where person.driver_status = 'free' " +
            " and car.car_type = 'wagon' limit 1"
    ,nativeQuery = true)
    Driver findByDriverStatusAndCarType(@Param("carType") String carType, @Param("driverStatus") DriverStatus driverStatus);
}
