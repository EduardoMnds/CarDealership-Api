package com.car_dealership.api_car_dealership.repositories;

import com.car_dealership.api_car_dealership.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserRepository, UUID> {

    Optional<UserModel> findByUserName(String username);
}
