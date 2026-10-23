package com.basespringboot.service;

import java.util.List;
import java.util.Optional;

import com.basespringboot.dto.CarDto;
import com.basespringboot.model.Car;

public interface CarService {
    List<Car> getAllCars();
    Optional<Car> getCarId(Long id);
    Car save(CarDto car);
    Optional<Car> update(Long id,CarDto carDto);
    boolean delete(Long id);
}
