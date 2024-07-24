package com.car_dealership.api_car_dealership.repositories;

import com.car_dealership.api_car_dealership.models.CarDealershipModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


import java.util.UUID;

@Repository
public interface CarDealershipRepository extends JpaRepository<CarDealershipModel , UUID> {

    boolean existsByPlateNumber(String plateNumber);
    Page<CarDealershipModel> findByModelCar(String modelCar, Pageable pageable);
}