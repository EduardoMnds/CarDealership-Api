package com.car_dealership.api_car_dealership.services;

import com.car_dealership.api_car_dealership.models.CarDealershipModel;
import com.car_dealership.api_car_dealership.repositories.CarDealershipRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarDealershipService {

    private final CarDealershipRepository carDealershipRepository;

        public CarDealershipService(CarDealershipRepository carDealershipRepository) {
        this.carDealershipRepository = carDealershipRepository;
    }


    @Transactional
    public CarDealershipModel save(CarDealershipModel carDealershipModel) {
        return carDealershipRepository.save(carDealershipModel);
    }

    public boolean existsByPlateNumber(String plateNumber){
        return carDealershipRepository.existsByPlateNumber(plateNumber);
    }

    public Page<CarDealershipModel> findAll(Pageable pageable){
        return carDealershipRepository.findAll(pageable);
    }

    public Optional<CarDealershipModel> findById(UUID id) {
        return carDealershipRepository.findById(id);
    }

    public Page<CarDealershipModel> findByModelCar(String modelCar, Pageable pageable) {
        return carDealershipRepository.findByModelCar(modelCar, pageable);
    }

    @Transactional
    public void delete(CarDealershipModel carDealershipModel) {
            carDealershipRepository.delete(carDealershipModel);
    }

}
