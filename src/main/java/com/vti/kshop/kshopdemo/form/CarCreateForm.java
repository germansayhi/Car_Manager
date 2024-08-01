package com.vti.kshop.kshopdemo.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarCreateForm {
    private String licensePlate;
    private LocalDate repairDate;
    private String customerName;
    private String catalog;
    private String carMaker;
}
