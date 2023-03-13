package com.bookmycar.BookMyCar.controller;

import com.bookmycar.BookMyCar.model.CarModel;
import com.bookmycar.BookMyCar.payload.request.CarOwnerDeal;
import com.bookmycar.BookMyCar.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("hasRole('CUSTOMER')")
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping("/getCarModelsByCapacity/{capacity}")
    public List<CarModel> findCarModelFromSeatCapacity(@PathVariable int capacity){
        System.out.println("hello");
        return customerService.getCarModelListFromSeatCapacity(capacity);
    }
    @GetMapping("/getCarModelsByBrand/{brand}")
    private List<CarModel> findCarModelFromCarBrand(@PathVariable String brand){
        return customerService.getCarModelListFromBrand(brand);
    }

    @GetMapping("/getCarOwners/{model}")
    private List<CarOwnerDeal> findCarOwnerFromModel(@PathVariable String model){
        return customerService.getCarOwnerListFromModel(model);
    }
}
