package com.bookmycar.BookMyCar.service;

import com.bookmycar.BookMyCar.model.Car;
import com.bookmycar.BookMyCar.model.CarModel;
import com.bookmycar.BookMyCar.repository.CarModelRepository;
import com.bookmycar.BookMyCar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarOwnerServiceImplementation implements CarOwnerService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    CarModelRepository carModelRepository;

    @Override
    public void addCar (Car car) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        SecurityContextHolder.getContext().setAuthentication(auth);
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();


        if (carModelRepository.existsByCarModel(car.getModel())){
            car.setOwner(userDetails.getId());
            String carId = carRepository.save(car).getCarId();
            CarModel carModel = carModelRepository.findByCarModel(car.getModel());
            carModel.getCarIdList().add(carId);
            carModelRepository.save(carModel);
        }
        else {
            car.setOwner(userDetails.getId());
            String carId = carRepository.save(car).getCarId();
            List<String> temp = new ArrayList<>();
            temp.add(carId);
            CarModel carModel = new CarModel(car.getBrand(),car.getModel(), car.getSeatCapacity(),temp);
            carModelRepository.save(carModel);
        }
    }

    @Override
    public void updateDistance (String carId, int distance) {
        Car car = carRepository.findById(carId).get();
        car.setDistanceTravelled(distance);
        carRepository.save(car);
    }

    @Override
    public void updateCarInsured (String carId, boolean insured) {
        Car car = carRepository.findById(carId).get();
        car.setInsured(insured);
        carRepository.save(car);
    }

    @Override
    public void updateCarBooked (String carId, boolean booked) {
        Car car = carRepository.findById(carId).get();
        car.setInsured(booked);
        carRepository.save(car);
    }
}
