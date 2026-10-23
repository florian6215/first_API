package com.basespringboot.controller;

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

import com.basespringboot.dto.GarageDto;
import com.basespringboot.model.Garage;
import com.basespringboot.service.GarageService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/garages")
@RestController
@RequiredArgsConstructor
public class GarageController {
    private final GarageService garageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Garage save(@Valid @RequestBody GarageDto garageDto) {
        return garageService.save(garageDto);
    }

    @GetMapping
    public List<Garage> getAllGarages() {
        return garageService.getAllGarages();
    }

    @GetMapping("/{id}")
    public Optional<Garage> getGarageById(@PathVariable Long id) {
        return garageService.getGarageById(id);
    }

    @PutMapping("/{id}")
    public Optional<Garage> update(@PathVariable Long id, @Valid @RequestBody GarageDto garageDto) {
        return garageService.update(id, garageDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable Long id) {
        return garageService.delete(id);
    }
}