package com.bookmycar.BookMyCar.controller;

import com.bookmycar.BookMyCar.model.Booking;
import com.bookmycar.BookMyCar.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/{carId}")
    public String bookCar (@PathVariable String carId, @RequestBody Booking booking) {
        return bookingService.book(carId, booking);
    }
}
