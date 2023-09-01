package com.example.learningapp.carexample.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Car {

    private static final Logger logger = LoggerFactory.getLogger(Car.class);

    private Long id;
    private String model;
    private String brand;
    private Integer horse;
    private Double price;

    public Car() {}

    public Car(Long id, String model, String brand, Integer horse, Double price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.horse = horse;
        this.price = price;
    }

    @Positive(message = "Car id must be greater than 0")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "Model must not be null")
    @NotEmpty(message = "Model must have a value")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getHorse() {
        return horse;
    }

    public void setHorse(Integer horse) {
        this.horse = horse;
    }

    @NotNull(message = "Price must not be null")
    @Positive
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(model, car.model) && Objects.equals(brand, car.brand) && Objects.equals(horse, car.horse) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, horse, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", horse=" + horse +
                ", price=" + price +
                '}';
    }

    private void buildCar() {
        logger.info("Car is being built");
    }

    private void scrapCar() {
        logger.info("Car is being scrapped");
    }
}
