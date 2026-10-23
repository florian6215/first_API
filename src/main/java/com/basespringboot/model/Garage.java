package com.basespringboot.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
public class Garage {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "garage",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

}
