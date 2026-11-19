package com.basespringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basespringboot.dto.CarDto;
import com.basespringboot.model.Car;
import com.basespringboot.model.Garage;
import com.basespringboot.repository.CarRepository;
import com.basespringboot.repository.GarageRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

// Transactional service implementation managing car persistence and garage links
@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final GarageRepository garageRepository;

    // Retrieve all cars from the database
    @Override 
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    // Retrieve a single car by ID if present
    @Override 
    public Optional<Car> getCarId(Long id){
        return carRepository.findById(id);
    }

    // Update car fields and re-associate or clear its garage if needed
    @Override 
    public Optional<Car> update(Long id,CarDto carDto){
        return carRepository.findById(id).map(car->{
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setYear(carDto.getYear());
            
            if (carDto.getGarageId() != null) {
                Garage garage = garageRepository.findById(carDto.getGarageId()).orElse(null);
                car.setGarage(garage);
            } else {
                car.setGarage(null);
            }

            return carRepository.save(car);
        });
    }

    // Delete a car by ID; returns false if no matching record exists
    @Override 
    public boolean delete(Long id){
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Create and save a new car, optionally linking an existing garage
    @Override
    public Car save(CarDto carDto) {
        Car car = new Car();
        car.setName(carDto.getName());
        car.setBrand(carDto.getBrand());
        car.setColor(carDto.getColor());
        car.setYear(carDto.getYear());

        if (carDto.getGarageId() != null) {
            Garage garage = garageRepository.findById(carDto.getGarageId()).orElse(null);
            car.setGarage(garage);
        }
        
        return carRepository.save(car);
    }
}