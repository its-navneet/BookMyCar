package com.bookmycar.BookMyCar.repository;

import com.bookmycar.BookMyCar.model.CarModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarModelRepository extends MongoRepository<CarModel,String> {
    boolean existsByCarBrand(String brandName);
    List<CarModel> findByCarBrand(String brandName);
    boolean existsByCarModel(String carModel);
    CarModel findByCarModel(String carModel);
    List<CarModel> findBySeatCapacity(int capacity);
}
