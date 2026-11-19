package com.basespringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basespringboot.dto.GarageDto;
import com.basespringboot.model.Garage;
import com.basespringboot.repository.GarageRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

// Transactional service implementation managing garage persistence
@Service
@Transactional
@RequiredArgsConstructor
public class GarageServiceImpl implements GarageService {
    private final GarageRepository garageRepository;

    // Retrieve all garages from the database
    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    // Retrieve a single garage by ID if present
    @Override
    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id);
    }

    // Create and persist a new garage from DTO fields
    @Override
    public Garage save(GarageDto garageDto) {
        Garage garage = new Garage();
        garage.setName(garageDto.getName());
        garage.setAddress(garageDto.getAddress());
        return garageRepository.save(garage);
    }

    // Update an existing garage's fields if found
    @Override
    public Optional<Garage> update(Long id, GarageDto garageDto) {
        return garageRepository.findById(id).map(garage -> {
            garage.setName(garageDto.getName());
            garage.setAddress(garageDto.getAddress());
            return garageRepository.save(garage);
        });
    }

    // Delete a garage by ID; returns false if no matching record exists
    @Override
    public boolean delete(Long id) {
        if (garageRepository.existsById(id)) {
            garageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}