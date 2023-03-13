package com.bookmycar.BookMyCar.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
  @Id
  private String id;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;


  private String profilePic;

  @Size(max = 1)
  private String role;

  @CreatedDate
  private Date accountCreatedOn;

  private String address;

  @Max(5)
  private int rating;

  private List<Car> car_list;

  public User(String username, String email, String password, String role, String profilePic) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = role;
    this.profilePic= profilePic;
  }


}
