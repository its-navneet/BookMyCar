package com.bookmycar.BookMyCar.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "car_models")
@NoArgsConstructor
@Getter
@Setter
public class CarModel {

    @Id
    public String carModelId;

    private String carBrand;

    private String carModel;

    private String carModelPic;

    @NotBlank
    @Max(value = 9)
    private int seatCapacity;

    public List<String> carIdList;

    public CarModel (String carBrand, String carModel, int seatCapacity, List<String> carIdList) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.seatCapacity = seatCapacity;
        this.carIdList = carIdList;
    }
}
