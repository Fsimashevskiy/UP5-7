package com.app.crud.service;

import com.app.crud.model.Car;

import javax.validation.ConstraintViolationException;
import java.util.List;

public interface CarService {
    List<Car> findAllCars();
    Car findCarById(int id);
    Car findCarByIdContains(int id);
    void save(Car car);
    void delete(int id);
}
