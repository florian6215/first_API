package com.basespringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basespringboot.dto.GarageDto;
import com.basespringboot.model.Garage;
import com.basespringboot.repository.GarageRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GarageServiceImpl implements GarageService {
    private final GarageRepository garageRepository;

    @Override
    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public Optional<Garage> getGarageById(Long id) {
        return garageRepository.findById(id);
    }

    @Override
    public Garage save(GarageDto garageDto) {
        Garage garage = new Garage();
        garage.setName(garageDto.getName());
        garage.setAddress(garageDto.getAddress());
        return garageRepository.save(garage);
    }

    @Override
    public Optional<Garage> update(Long id, GarageDto garageDto) {
        return garageRepository.findById(id).map(garage -> {
            garage.setName(garageDto.getName());
            garage.setAddress(garageDto.getAddress());
            return garageRepository.save(garage);
        });
    }

    @Override
    public boolean delete(Long id) {
        if (garageRepository.existsById(id)) {
            garageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}