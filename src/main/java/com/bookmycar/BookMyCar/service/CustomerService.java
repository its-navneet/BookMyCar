package com.bookmycar.BookMyCar.service;

import com.bookmycar.BookMyCar.model.CarModel;
import com.bookmycar.BookMyCar.payload.request.CarOwnerDeal;

import java.util.List;

public interface CustomerService {
    List<CarModel> getCarModelListFromSeatCapacity (int capacity);

    List<CarModel> getCarModelListFromBrand (String brand);

    List<CarOwnerDeal> getCarOwnerListFromModel (String model);
}
