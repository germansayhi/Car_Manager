package com.vti.kshop.kshopdemo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Getter
@Setter
public class CarUpdateForm {
    @NotBlank(message = "{car.licensePlate.NotBlank.message}")
    @Length(max =50, message = "{car.licensePlate.Length.message}")
    private String licensePlate;

    @NotNull(message = "Car repairDate must not be blank")
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
