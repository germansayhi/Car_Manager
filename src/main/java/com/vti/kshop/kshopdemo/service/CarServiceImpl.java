package com.vti.kshop.kshopdemo.service;

import com.vti.kshop.kshopdemo.dto.CarDto;
import com.vti.kshop.kshopdemo.form.CarCreateForm;
import com.vti.kshop.kshopdemo.form.CarFilterForm;
import com.vti.kshop.kshopdemo.form.CarUpdateForm;
import com.vti.kshop.kshopdemo.mapper.CarMapper;
import com.vti.kshop.kshopdemo.repository.CarRepository;
import com.vti.kshop.kshopdemo.specification.CarSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService{
    private CarRepository carRepository;


    @Override
    public CarDto create(CarCreateForm form) {
        var car = CarMapper.map(form);
        var savedCar= carRepository.save(car);
        return CarMapper.map(savedCar);
    }

    @Override
    public Page<CarDto> findAll(CarFilterForm form, Pageable pageable) {
        var spec = CarSpecification.buildSpec(form);
        return carRepository.findAll(spec, pageable)
                .map(CarMapper::map);
    }

    @Override
    public CarDto findById(Long id) {
        return carRepository.findById(id)
                .map(CarMapper::map)
                .orElse(null);
    }

    @Override
    public CarDto update(Long id, CarUpdateForm form) {
        var optional = carRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        var car = optional.get();
        CarMapper.map(form,car);
        var saveCar = carRepository.save(car);
        return CarMapper.map(saveCar);
    }

    @Override
    public void deleteId(Long id) {
        carRepository.deleteById(id);
    }
}
