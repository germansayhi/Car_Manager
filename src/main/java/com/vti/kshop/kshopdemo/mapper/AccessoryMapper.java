package com.vti.kshop.kshopdemo.mapper;

import com.vti.kshop.kshopdemo.dto.AccessoryDto;
import com.vti.kshop.kshopdemo.entity.Accessory;
import com.vti.kshop.kshopdemo.form.AccessoryCreateForm;
import com.vti.kshop.kshopdemo.form.AccessoryUpdateForm;

public class AccessoryMapper {
    public static Accessory map(AccessoryCreateForm form){
        var accessory = new Accessory();
        accessory.setStatusDamaged(form.getStatusDamaged());
        accessory.setName(form.getName());
        accessory.setPrice(form.getPrice());
        accessory.setRepairStatus(form.getRepairStatus());
        return accessory;
    }
    public static AccessoryDto map(Accessory accessory){
        var dto = new AccessoryDto();
        dto.setId(accessory.getId());
        dto.setName(accessory.getName());
        dto.setPrice(accessory.getPrice());
        dto.setStatusDamaged(accessory.getStatusDamaged());
        dto.setRepairStatus(accessory.getRepairStatus());
        dto.setRepairDate(accessory.getCar().getRepairDate());
        dto.setLicensePlate(accessory.getCar().getLicensePlate());
        return dto;
    }
    public static void map(AccessoryUpdateForm form, Accessory accessory){
        accessory.setStatusDamaged(form.getStatusDamaged());
        accessory.setName(form.getName());
        accessory.setPrice(form.getPrice());
        accessory.setRepairStatus(form.getRepairStatus());
    }
}
