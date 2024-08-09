package com.vti.kshop.kshopdemo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class CarUpdateForm {
    @NotBlank(message = "Car LicensePlate must not be blank")
    @Length(max =50, message = "Car LicensePlate has max 50 character")
    private String licensePlate;

    @NotBlank(message = "Car repairDate must not be blank")
    @PastOrPresent
    private LocalDate repairDate;

    @NotBlank(message = "Car CustomerName must not be blank")
    @Length(max =50, message = "Car CustomerName has max 50 character")
    private String customerName;

    @NotBlank(message = "Car Catalog must not be blank")
    @Length(max =50, message = "Car Catalog has max 50 character")
    private String catalog;

    @NotBlank(message = "CarMaker must not be blank")
    @Length(max =50, message = "CarMaker has max 50 character")
    private String carMaker;
}
