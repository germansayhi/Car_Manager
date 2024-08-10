package com.vti.kshop.kshopdemo.service;

import com.vti.kshop.kshopdemo.dto.AccessoryDto;
import com.vti.kshop.kshopdemo.form.AccessoryCreateForm;
import com.vti.kshop.kshopdemo.form.AccessoryFilterForm;
import com.vti.kshop.kshopdemo.form.AccessoryUpdateForm;
import com.vti.kshop.kshopdemo.mapper.AccessoryMapper;
import com.vti.kshop.kshopdemo.repository.AccessoryRepository;
import com.vti.kshop.kshopdemo.repository.CarRepository;
import com.vti.kshop.kshopdemo.specification.AccessorySpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccessoryServiceImpl implements  AccessoryService{
    private AccessoryRepository accessoryRepository;
    private CarRepository carReponsitory;

    @Override
    public AccessoryDto create(AccessoryCreateForm form) {
        var car = carReponsitory.findByLicensePlateAndRepairDate(
                form.getLicensePlate(),
                form.getRepairDate()
        );
        if(car == null) return null;
        var accessory = AccessoryMapper.map(form);
        accessory.setCar(car);
        var saveAccessory = accessoryRepository.save(accessory);
        return AccessoryMapper.map(saveAccessory);
    }

    @Override
    public Page<AccessoryDto> findAll(AccessoryFilterForm form, Pageable pageable) {
        var spec = AccessorySpecification.buildSpec(form);
        return accessoryRepository.findAll(spec, pageable)
                .map(AccessoryMapper::map);
    }

    @Override
    public AccessoryDto findById(Long id) {
        return accessoryRepository.findById(id)
                .map(AccessoryMapper::map)
                .orElse(null);
    }

    @Override
    public AccessoryDto update(Long id, AccessoryUpdateForm form) {
        var optional = accessoryRepository.findById(id);
        if(optional.isEmpty()){
            return null;
        }
        var accessory = optional.get();
        AccessoryMapper.map(form,accessory);
        var saveCar = accessoryRepository.save(accessory);
        return AccessoryMapper.map(saveCar);
    }

    @Override
    public void deleteByID(long id) {
        accessoryRepository.deleteById(id);
    }
}
