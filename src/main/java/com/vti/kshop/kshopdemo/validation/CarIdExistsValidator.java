package com.vti.kshop.kshopdemo.validation;

import com.vti.kshop.kshopdemo.repository.CarRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CarIdExistsValidator
        implements ConstraintValidator<CarIdExists, Long> {
    private CarRepository carRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        return carRepository.existsById(id);
    }
}
