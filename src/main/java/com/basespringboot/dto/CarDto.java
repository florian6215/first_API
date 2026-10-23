package com.basespringboot.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class CarDto {
    @NotBlank 
    private String name;

    private String marque;
    private String couleur;
    private int annee;
}
