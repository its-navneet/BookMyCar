package com.bookmycar.BookMyCar.service;

import com.bookmycar.BookMyCar.model.Car;

public interface CarOwnerService {

    void addCar (Car car);

    void updateDistance (String carId,int distance);

    void updateCarInsured (String carId, boolean insured);

    void updateCarBooked (String carId, boolean booked);
}
