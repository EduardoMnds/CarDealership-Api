package com.car_dealership.api_car_dealership.controllers;

import com.car_dealership.api_car_dealership.dtos.CarDealershipDto;
import com.car_dealership.api_car_dealership.enums.Messages;
import com.car_dealership.api_car_dealership.models.CarDealershipModel;
import com.car_dealership.api_car_dealership.services.CarDealershipService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/car-dealership")
public class CarDealershipController {

    final CarDealershipService carDealershipService;

    public CarDealershipController(CarDealershipService carDealershipService ) {
        this.carDealershipService = carDealershipService;
    }

    @PostMapping("/update")
    public ResponseEntity<Object> saveCarDealership(@RequestBody @Valid CarDealershipDto carDealerShipDto) {

        if (carDealershipService.existsByPlateNumber(carDealerShipDto.getPlateNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Plate Number already exists");
        }

        CarDealershipModel carDealershipModel = new CarDealershipModel();
        BeanUtils.copyProperties(carDealerShipDto, carDealershipModel);
        carDealershipModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(Messages.Message_UpdateSuccess);
    }

    @GetMapping("/list")
    public ResponseEntity<Page<CarDealershipModel>> getAllCarDealerships(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carDealershipService.findAll(pageable));
    }

    @GetMapping("/list-id/{id}")
    public ResponseEntity<Object> getOneCarDealership(@PathVariable (value = "id") UUID id) {
        if (carDealershipService.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(carDealershipService.findById(id));
    }

    @GetMapping("/list-car/{modelCar}")
    public ResponseEntity<Page<CarDealershipModel>> getAllCarModel(@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable, @PathVariable String modelCar){
        Page<CarDealershipModel> carModels = carDealershipService.findByModelCar(modelCar, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(carModels);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteCarDealership(@PathVariable(value = "id") UUID id) {
        Optional<CarDealershipModel> carDealershipModelOptional = carDealershipService.findById(id);
        if (!carDealershipService.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        carDealershipService.delete(carDealershipModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(carDealershipModelOptional.get());
    }

    @PutMapping("/att/{id}")
    public ResponseEntity<Object> updateCarDealership(@PathVariable (value = "id") UUID id, @RequestBody @Valid CarDealershipDto carDealerShipDto) {
        Optional<CarDealershipModel> carDealershipModelOptional = carDealershipService.findById(id);
        if (!carDealershipModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID Not Found");
        }
        CarDealershipModel carDealershipModel = carDealershipModelOptional.get();
        carDealershipModel.setBrandCar(carDealerShipDto.getBrandCar());
        carDealershipModel.setModelCar(carDealerShipDto.getModelCar());
        carDealershipModel.setModelYear(carDealerShipDto.getModelYear());
        carDealershipModel.setColorCar(carDealerShipDto.getColorCar());
        carDealershipModel.setPriceCar(carDealerShipDto.getPriceCar());
        carDealershipModel.setDriverLicenseNumber(carDealershipModel.getPlateNumber());
        carDealershipModel.setResponsibleName(carDealershipModel.getResponsibleName());
        return ResponseEntity.status(HttpStatus.OK).body(carDealershipService.save(carDealershipModel));
    }
}