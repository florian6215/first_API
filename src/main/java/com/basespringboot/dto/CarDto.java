package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CarDto {
    @NotBlank 
    private String name;
    private String brand;
    private String color;
    private int year;
    private Long garageId;
}
