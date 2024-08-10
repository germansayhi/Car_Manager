package com.vti.kshop.kshopdemo.controller;

import com.vti.kshop.kshopdemo.dto.AccessoryDto;
import com.vti.kshop.kshopdemo.form.AccessoryCreateForm;
import com.vti.kshop.kshopdemo.form.AccessoryFilterForm;
import com.vti.kshop.kshopdemo.form.AccessoryUpdateForm;
import com.vti.kshop.kshopdemo.service.AccessoryService;
import com.vti.kshop.kshopdemo.validation.CarIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@Validated
public class AccessoryController {
    private AccessoryService accessoryService;

    @PostMapping("api/v1/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryDto create(@RequestBody @Valid AccessoryCreateForm form){
        return accessoryService.create(form);
    }

    @GetMapping("/api/v1/accessories")
    public Page<AccessoryDto> findAll(AccessoryFilterForm form, Pageable pageable){
        return accessoryService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/accessories/{id}")
    public AccessoryDto findByID(@PathVariable("id") @CarIdExists Long id){
        return accessoryService.findById(id);
    }

    @PutMapping("/api/v1/accessories/{id}")
    public AccessoryDto update(@PathVariable("id") Long id,@RequestBody @CarIdExists AccessoryUpdateForm form){
        return accessoryService.update(id,form);
    }

    @DeleteMapping("/api/v1/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id") @CarIdExists Long id){
        accessoryService.deleteByID(id);

    }
}
