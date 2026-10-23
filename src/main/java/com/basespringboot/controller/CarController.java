package com.basespringboot.controller;

import com.basespringboot.dto.CarDto;
import com.basespringboot.model.Car;
import com.basespringboot.service.CarService;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public Optional<Car> getCarId(@PathVariable Long id) {
        return carService.getCarId(id);
    }

    @PutMapping("/{id}")
    public Optional<Car> update(@PathVariable Long id, @Valid @RequestBody CarDto carDto) {
        return carService.update(id, carDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Long id) {
        return carService.delete(id);
    }
}