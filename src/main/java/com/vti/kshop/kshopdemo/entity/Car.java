package com.vti.kshop.kshopdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name= "car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_plate", length = 50, nullable = false)
    private String licensePlate;

    @Column(name = "repair_date", nullable = false )
    private LocalDate repairDate;

    @Column(name = "customer_name",length = 50, nullable = false)
    private String customerName;

    @Column(name = "catalog", nullable = false,length = 50)
    private String catalog;

    @Column(name = "car_maker", nullable = false, length = 50)
    private String carMaker;

    @OneToMany(mappedBy = "car")
    private List<Accessory> accessories;
}
