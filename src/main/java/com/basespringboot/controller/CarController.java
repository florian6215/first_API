package com.basespringboot.controller;

import com.basespringboot.dto.CarDto;
import com.basespringboot.model.Car;
import com.basespringboot.service.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/cars")
@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car save(@Valid @RequestBody CarDto carDto) {
        return carService.save(carDto);
    }
}