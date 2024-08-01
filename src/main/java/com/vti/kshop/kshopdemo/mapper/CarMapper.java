package com.vti.kshop.kshopdemo.mapper;


import com.vti.kshop.kshopdemo.dto.CarDto;
import com.vti.kshop.kshopdemo.entity.Car;
import com.vti.kshop.kshopdemo.form.CarCreateForm;
import com.vti.kshop.kshopdemo.form.CarUpdateForm;

public class CarMapper {
    public static Car map(CarCreateForm form) {
        var car = new Car();
        car.setLicensePlate(form.getLicensePlate());
        car.setCarMaker(form.getCarMaker());
        car.setRepairDate(form.getRepairDate());
        car.setCustomerName(form.getCustomerName());
        car.setCatalog(form.getCatalog());
        return car;
    }
    public static CarDto map(Car car){
        var dto = new CarDto();
        dto.setCarMaker(car.getCarMaker());
        dto.setId(car.getId());
        dto.setCatalog(car.getCatalog());
        dto.setRepairDate(car.getRepairDate());
        dto.setLicensePlate(car.getLicensePlate());
        dto.setCustomerName(car.getCustomerName());
        return dto;
    }
    public static void map(CarUpdateForm form, Car car){
        car.setLicensePlate(form.getLicensePlate());
        car.setCarMaker(form.getCarMaker());
        car.setRepairDate(form.getRepairDate());
        car.setCustomerName(form.getCustomerName());
        car.setCatalog(form.getCatalog());
    }
}
