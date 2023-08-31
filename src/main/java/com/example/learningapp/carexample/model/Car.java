package com.example.learningapp.carexample.model;

public class Car {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
}
