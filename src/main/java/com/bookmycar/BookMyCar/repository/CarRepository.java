package com.bookmycar.BookMyCar.repository;

import com.bookmycar.BookMyCar.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {
    Optional<Car> findById(String id);
    List<Car> findByBrand(String model);
    List<Car> findByModel(String model);
    List<Car> findBySeatCapacity(int capacity);
    List<Car> findByColor(String color);
    List<Car> findByDistanceTravelled(int distance);
    List<Car> findByBooked(Boolean booked);
    List<Car> findByOwner(String ownerId);
}
