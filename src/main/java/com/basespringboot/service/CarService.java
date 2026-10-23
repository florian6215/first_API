package com.basespringboot.service;

import com.basespringboot.dto.CarDto;
import com.basespringboot.model.Car;

public interface CarService {
    Car save(CarDto car);
}
