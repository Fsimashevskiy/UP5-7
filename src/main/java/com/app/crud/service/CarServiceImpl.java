package com.app.crud.service;

import com.app.crud.model.Car;
import com.app.crud.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }


    @Override
    public Car findCarById(int id) {
        return carRepository.findCarById(id);
    }

    @Override
    public Car findCarByIdContains(int id) {
        return carRepository.findCarByIdContains(id);
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(int id) {
        carRepository.delete(carRepository.findCarById(id));
    }
}
