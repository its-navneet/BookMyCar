package com.bookmycar.BookMyCar.payload.request;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public class CarOwnerDeal {
    @NotBlank
    @Size(max = 20)
    private String username;

    private String address;

    @Max(5)
    private int rating;

    @NotBlank
    private int bookPrice;

}