package com.bookmycar.BookMyCar.controller;

import com.bookmycar.BookMyCar.model.Car;
import com.bookmycar.BookMyCar.payload.response.MessageResponse;
import com.bookmycar.BookMyCar.service.CarOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasRole('CAR_OWNER')")
@RequestMapping("/api/car_owner")
public class CarOwnerController {

    @Autowired
    CarOwnerService carOwnerService;

    @PostMapping("/addCar")
    public ResponseEntity<?> addCar (@RequestBody Car car) {
        carOwnerService.addCar(car);
        return ResponseEntity.ok(new MessageResponse("Car registered successfully!"));
    }

    @PatchMapping("/modify/{carId}/{distance}")
    public ResponseEntity<?> updateCarDistance (@PathVariable String carId, @PathVariable int distance) {
        carOwnerService.updateDistance(carId, distance);
        return ResponseEntity.ok(new MessageResponse("Distance travelled updated successfully!"));
    }

    @PatchMapping("/modify/{carId}/{insured}")
    public ResponseEntity<?> updateCarInsured (@PathVariable String carId, @PathVariable boolean insured) {
        carOwnerService.updateCarInsured(carId, insured);
        return ResponseEntity.ok(new MessageResponse("Distance travelled updated successfully!"));
    }

    @PatchMapping("/modify/{carId}/{booked}")
    public ResponseEntity<?> updateCarBooked (@PathVariable String carId, @PathVariable boolean booked) {
        carOwnerService.updateCarBooked(carId, booked);
        return ResponseEntity.ok(new MessageResponse("Distance travelled updated successfully!"));
    }


}
