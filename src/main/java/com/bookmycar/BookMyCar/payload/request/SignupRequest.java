package com.bookmycar.BookMyCar.payload.request;

import com.bookmycar.BookMyCar.model.Car;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@Data
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private String role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  private String profilePic;

  private String address;

  @Max(5)
  private int rating;

  private List<Car> car_list;
}
