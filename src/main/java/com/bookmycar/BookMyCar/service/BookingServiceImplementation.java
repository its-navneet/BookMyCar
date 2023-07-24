package com.bookmycar.BookMyCar.service;

import com.bookmycar.BookMyCar.model.Booking;
import com.bookmycar.BookMyCar.model.Car;
import com.bookmycar.BookMyCar.repository.BookingRepository;
import com.bookmycar.BookMyCar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class BookingServiceImplementation implements BookingService{

    @Autowired
    CarRepository carRepository;

    @Autowired
    BookingRepository bookingRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    @Override
    public String book (String carId, Booking booking) {
        Car selectedCar = carRepository.findById(carId).get();
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        selectedCar.setBooked(true);
        booking.setCarId(carId);
        booking.setUserId(user.getId());
        booking.setOwnerId(selectedCar.getOwner());
        booking.setCreatedAt(LocalDateTime.now());
        booking.setEndTime(booking.getStartTime().plusHours(booking.getDuration()));
        carRepository.save(selectedCar);
        bookingRepository.save(booking);
        return "Car booked successfully!";
    }
}
