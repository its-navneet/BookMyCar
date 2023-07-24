package com.bookmycar.BookMyCar.service;

import com.bookmycar.BookMyCar.model.Car;
import com.bookmycar.BookMyCar.model.CarModel;
import com.bookmycar.BookMyCar.model.User;
import com.bookmycar.BookMyCar.payload.request.CarOwnerDeal;
import com.bookmycar.BookMyCar.repository.CarModelRepository;
import com.bookmycar.BookMyCar.repository.CarRepository;
import com.bookmycar.BookMyCar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    CarModelRepository carModelRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    UserRepository userRepository;




    @Override
    public List<CarModel> getCarModelListFromSeatCapacity (int capacity) {
        return carModelRepository.findBySeatCapacity(capacity);
    }

    @Override
    public List<CarModel> getCarModelListFromBrand (String brand) {
        return carModelRepository.findByCarBrand(brand);
    }

    @Override
    public List<CarOwnerDeal> getCarOwnerListFromModel (String model) {
        List<CarOwnerDeal> ownerDeals = new ArrayList<>();
        for(Car car: carRepository.findByModel(model)){
            User user = userRepository.findById(car.getOwner()).get();
            CarOwnerDeal carOwnerDeal = new CarOwnerDeal(user.getUsername(),user.getAddress(), user.getRating(),car.getBookPrice());
            ownerDeals.add(carOwnerDeal);
        }
        return ownerDeals;
    }

    @Override
    public List<Car> getCarFromOwnerAndModel (String ownerId, String modelName) {
        List<Car> carList = carRepository.findByOwner(ownerId);
        List<Car> list = new ArrayList<>();
        for(Car car:carList){
            if(car.getModel()==modelName){
                list.add(car);
            }
        }
        return list;
    }

    @Override
    public Car getCar(String carId) {
        return carRepository.findById(carId).get();
    }
}
