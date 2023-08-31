package com.example.learningapp.carexample.controller;

import com.example.learningapp.carexample.model.Car;
import com.example.learningapp.carexample.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        logger.info("getting all cars");
        return carService.getAllCars();
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllFilteredByPrice(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        logger.info("Getting cars with param minPrice: {} and maxPrice {}", minPrice, maxPrice);
        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id) {
        logger.info("getting car by id: {}", id);
        return carService.getById(id);
    }

    @PostMapping
    public void createCar(@RequestBody Car car) {
        logger.info("creating car: {}", car);
        carService.create(car);
    }
}
