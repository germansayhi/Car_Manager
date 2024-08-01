package com.vti.kshop.kshopdemo.controller;

import com.vti.kshop.kshopdemo.dto.AccessoryDto;
import com.vti.kshop.kshopdemo.form.AccessoryCreateForm;
import com.vti.kshop.kshopdemo.form.AccessoryUpdateForm;
import com.vti.kshop.kshopdemo.service.AccessoryService;
import com.vti.kshop.kshopdemo.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class AccessoryController {
    private AccessoryService accessoryService;

    @PostMapping("api/v1/accessories")
    @ResponseStatus(HttpStatus.CREATED)
    public AccessoryDto create(@RequestBody AccessoryCreateForm form){
        return accessoryService.create(form);
    }

    @GetMapping("/api/v1/accessories")
    public Page<AccessoryDto> findAll(Pageable pageable){
        return accessoryService.findAll(pageable);
    }

    @GetMapping("/api/v1/accessories/{id}")
    public AccessoryDto findByID(@PathVariable("id") Long id){
        return accessoryService.findById(id);
    }

    @PutMapping("/api/v1/accessories/{id}")
    public AccessoryDto update(@PathVariable("id") Long id,@RequestBody AccessoryUpdateForm form){
        return accessoryService.update(id,form);
    }

    @DeleteMapping("/api/v1/accessories/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable("id")Long id){
        accessoryService.deleteByID(id);

    }
}
