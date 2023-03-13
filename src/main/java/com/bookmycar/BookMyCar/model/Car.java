package com.bookmycar.BookMyCar.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "cars")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    public String carId;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    @Max(value = 9)
    private int seatCapacity;

    @NotBlank
    private String color;

    @NotBlank
    private String fuelType;

    @NotBlank
    private String typeOfDrive;

    @NotBlank
    private int topSpeed;

    @NotBlank
    private int distanceTravelled;

    @NotBlank
    private List<String> carPhoto;

    @NotBlank
    private boolean insured;

    @NotBlank
    private boolean booked;

    @NotBlank
    private String carNumber;

    @NotBlank
    private int quantity;

    @NotBlank
    private int bookPrice;

    @NotBlank
    private String owner;
}
