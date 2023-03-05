package com.bookmycar.BookMyCar.repository;

import com.bookmycar.BookMyCar.model.ERole;
import com.bookmycar.BookMyCar.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
  Optional<Role> findByName(ERole name);
}
