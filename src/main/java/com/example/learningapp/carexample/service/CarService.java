package com.example.learningapp.carexample.service;

import com.example.learningapp.carexample.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getCarsWithPriceFilter(Double min, Double max);

    Car getById(Long id);

    Car update(Long id, Car car);

    Car create(Car car);

    void delete(Long id);
}
