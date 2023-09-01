package com.example.learningapp.carexample.controller;

import com.example.learningapp.carexample.model.Car;
import com.example.learningapp.carexample.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated //@Positive and other validation won't run if this is not provided
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    private final CarService carService;

    //@Autowired // optional since spring 4.2 in constructor injection
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        logger.info("getting all cars");
        return carService.getAllCars();
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllFilteredByPrice(@RequestParam @Positive Double minPrice, @RequestParam @Positive Double maxPrice) {
        logger.info("Getting cars with param minPrice: {} and maxPrice {}", minPrice, maxPrice);
        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable @Positive Long id) {
        logger.info("getting car by id: {}", id);
        return carService.getById(id);
    }

    @PostMapping
    public Car createCar(@RequestBody @Valid Car car) {
        logger.info("creating car: {}", car);
        return carService.create(car);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Long id, @RequestBody Car car) {
        logger.info("updating car: {}", id);
        return carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        logger.info("deleting car by id: {}", id);
        carService.delete(id);
    }
}
