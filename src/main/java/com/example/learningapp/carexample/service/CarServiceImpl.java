package com.example.learningapp.carexample.service;

import com.example.learningapp.carexample.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = new ArrayList<>(
            Arrays.asList(
                    new Car(1L,"Astra", "Opel", 100, 18000d),
                    new Car(2L, "Insignia", "Opel", 120, 22000d),
                    new Car(3L, "Golf", "VW", 90, 17000d)
            )
    );

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
        return cars.stream()
                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
                .toList();
    }

    @Override
    public Car getById(Long id) {
        return cars.stream()
                .filter(car -> car.getId().equals(id))
                .findAny()
                .orElseThrow();
    }

    @Override
    public Car update(Long id, Car car) {
        Car carToBeUpdated = getById(id);
        carToBeUpdated.setBrand(car.getBrand());
        carToBeUpdated.setHorse(car.getHorse());
        carToBeUpdated.setModel(car.getModel());
        carToBeUpdated.setPrice(car.getPrice());
        return carToBeUpdated;
    }

    @Override
    public Car create(Car car) {
        Long newId = cars.stream().mapToLong(c -> c.getId()).max().orElse(0L) + 1;
        car.setId(newId);
        cars.add(car);

        return car;
    }

    @Override
    public void delete(Long id) {
        boolean isDeleted = cars.removeIf(car -> car.getId().equals(id));

        if (!isDeleted) {
            throw new NoSuchElementException("No cars to delete with id "+ id);
        }
    }
}
