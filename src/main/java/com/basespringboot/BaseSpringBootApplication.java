package com.basespringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.basespringboot.model.Car;
import com.basespringboot.model.Garage;
import com.basespringboot.repository.CarRepository;
import com.basespringboot.repository.GarageRepository;

@SpringBootApplication
public class BaseSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseSpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(GarageRepository garageRepository, CarRepository carRepository) {
        return args -> {
            Garage g = new Garage();
            g.setName("Garage Central");
            g.setAddress("12 Rue de la paix");
            garageRepository.save(g);

            Car c = new Car();
            c.setName("Clio");
            c.setBrand("Renault");
            c.setColor("Gris");
            c.setYear(2021);
            c.setGarage(g);
            carRepository.save(c);
        };
    }

}
