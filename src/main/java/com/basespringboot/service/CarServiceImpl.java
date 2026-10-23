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

@Service
@Transactional
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final GarageRepository garageRepository;

    @Override 
    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    @Override 
    public Optional<Car> getCarId(Long id){
        return carRepository.findById(id);
    }

    @Override 
    public Optional<Car> update(Long id,CarDto carDto){
        return carRepository.findById(id).map(car->{
            car.setName(carDto.getName());
            car.setMarque(carDto.getMarque());
            car.setCouleur(carDto.getCouleur());
            car.setAnnee(carDto.getAnnee());
            
            if (carDto.getGarageId() != null) {
                Garage garage = garageRepository.findById(carDto.getGarageId()).orElse(null);
                car.setGarage(garage);
            } else {
                car.setGarage(null);
            }

            return carRepository.save(car);
        });
    }

    @Override 
    public boolean delete(Long id){
        if(carRepository.existsById(id)){
            carRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Car save(CarDto carDto) {
        Car car = new Car();
        car.setName(carDto.getName());
        car.setMarque(carDto.getMarque());
        car.setCouleur(carDto.getCouleur());
        car.setAnnee(carDto.getAnnee());

        if (carDto.getGarageId() != null) {
            Garage garage = garageRepository.findById(carDto.getGarageId()).orElse(null);
            car.setGarage(garage);
        }
        
        return carRepository.save(car);
    }
}