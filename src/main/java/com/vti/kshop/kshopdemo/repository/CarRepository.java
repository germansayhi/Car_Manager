package com.vti.kshop.kshopdemo.repository;

import com.vti.kshop.kshopdemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;

public interface CarRepository extends JpaRepository<Car, Long>, JpaSpecificationExecutor<Car> {
    Car findByLicensePlateAndRepairDate(String licensePlate, LocalDate repairDate);


}
