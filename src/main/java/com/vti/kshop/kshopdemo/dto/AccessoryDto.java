package com.vti.kshop.kshopdemo.dto;

import com.vti.kshop.kshopdemo.controller.AccessoryController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDate;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Getter
@Setter
public class AccessoryDto extends RepresentationModel<AccessoryDto> {
    private Long id;
    private String licensePlate;
    private LocalDate repairDate;
    private String name;
    private Long price;
    private String statusDamaged;
    private String repairStatus;

    public AccessoryDto withSelfRel(){
        var controller = methodOn(AccessoryController.class);
        var dto = controller.findByID(id);
        var link = linkTo(dto).withSelfRel();
        return add(link);
    }
}
