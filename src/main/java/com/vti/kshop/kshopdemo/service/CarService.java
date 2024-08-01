package com.vti.kshop.kshopdemo.service;

import com.vti.kshop.kshopdemo.dto.CarDto;
import com.vti.kshop.kshopdemo.form.CarCreateForm;
import com.vti.kshop.kshopdemo.form.CarUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
    CarDto create(CarCreateForm form);

    Page<CarDto> findAll(Pageable pageable);

    CarDto findById(Long id);

    CarDto update (Long id, CarUpdateForm form);

    void deleteId (Long id);
}
