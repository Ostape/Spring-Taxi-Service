package com.robosh.repository;

import com.robosh.model.entities.Driver;
import com.robosh.model.enums.DriverStatus;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Optional;


public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByPhoneNumberAndPassword(String phoneNumber, String password);

    Driver findByPhoneNumber(String phoneNumber);

    @Modifying
    @Query(value = "UPDATE person SET driver_status = :driverStatus WHERE (person_id = :personId)", nativeQuery = true)
    void updateDriverStatus(@Param("driverStatus") String driverStatus, @Param("personId") Long personId);

    @Query(value = "select person.name, person.surname, person.person_id," +
            " person.active, person.password, person.phone_number, person.driver_status, person.middle_name, person.id_car, person.role from person " +
            " join car on person.id_car = car.id_car " +
            " where person.driver_status = :driverStatus " +
            " and car.car_type = :carType limit 1"
            , nativeQuery = true)
    Driver findByDriverStatusAndCarType(@Param("carType") String carType, @Param("driverStatus") String driverStatus);
}
