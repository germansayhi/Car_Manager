package com.vti.kshop.kshopdemo.controller;

import com.vti.kshop.kshopdemo.dto.CarDto;
import com.vti.kshop.kshopdemo.form.CarCreateForm;
import com.vti.kshop.kshopdemo.form.CarUpdateForm;
import com.vti.kshop.kshopdemo.service.CarService;
import com.vti.kshop.kshopdemo.validation.CarIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@Validated
public class CarController {
    private CarService carService;

    @GetMapping("/api/v1/cars")
    public Page<CarDto> findAll(Pageable pageable){
        return carService.findAll(pageable);
    }

    @GetMapping("/api/v1/cars/{id}")
    public CarDto findById(@PathVariable("id") @CarIdExists Long id){
        return carService.findById(id);
    }

    @PostMapping("/api/v1/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public  CarDto create(@RequestBody @Valid CarCreateForm form){
        return carService.create(form);
    }

    @PutMapping("/api/v1/cars/{id}")
    public CarDto update(@PathVariable("id") Long id,@RequestBody @CarIdExists CarUpdateForm form){
        return carService.update(id, form);
    }

    @DeleteMapping("/api/v1/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") @CarIdExists Long id){
        carService.deleteId(id);
    }
}
