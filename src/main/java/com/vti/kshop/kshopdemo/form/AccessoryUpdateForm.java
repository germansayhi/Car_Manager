package com.vti.kshop.kshopdemo.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryUpdateForm {
    private String name;
    private Long price;
    private String licensePlate;
    private LocalDate repairDate;
    private String statusDamaged;
    private String repairStatus;
}
