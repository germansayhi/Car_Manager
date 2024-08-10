package com.vti.kshop.kshopdemo.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CarFilterForm {
    private String search;
    private LocalDate minCreatedAt;
    private LocalDate maxCreatedAt;
    private String searchName;
}
