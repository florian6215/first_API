package com.basespringboot.service;

import java.util.List;
import java.util.Optional;

import com.basespringboot.dto.GarageDto;
import com.basespringboot.model.Garage;

public interface GarageService {
    List<Garage> getAllGarages();
    Optional<Garage> getGarageById(Long id);
    Garage save(GarageDto garageDto);
    Optional<Garage> update(Long id, GarageDto garageDto);
    boolean delete(Long id);
}