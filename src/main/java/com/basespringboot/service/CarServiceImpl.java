package com.basespringboot.service;

import org.springframework.stereotype.Service;

import com.basespringboot.dto.CarDto;
import com.basespringboot.model.Car;
import com.basespringboot.repository.CarRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    @Override
    public Car save(CarDto carDto) {
        Car car = new Car();
        car.setName(carDto.getName());
        car.setRarety(carDto.getRarety());
        car.setBoostSpeed(carDto.getBoostSpeed());
        
        return carRepository.save(car);
    }
}