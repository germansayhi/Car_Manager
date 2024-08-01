package com.vti.kshop.kshopdemo.repository;

import com.vti.kshop.kshopdemo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByLicensePlateAndRepairDate(String licensePlate, LocalDate repairDate);
}
