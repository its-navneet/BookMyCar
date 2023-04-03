package com.bookmycar.BookMyCar.repository;

import com.bookmycar.BookMyCar.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends MongoRepository<Booking,String> {
    Optional<List<Booking>> findByCarId(String carId);

}
