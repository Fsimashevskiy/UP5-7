package com.app.crud.repository;

import com.app.crud.model.Car;
import com.app.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByUser(User user);
    List<Car> findAllByUserContains(User user);
    Car findCarById(int id);
    Car findCarByIdContains(int id);
}
