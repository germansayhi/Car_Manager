package com.vti.kshop.kshopdemo.form;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AccessoryFilterForm {
    private String searchName;
    private Long searchPrice;
    private String search;
}
