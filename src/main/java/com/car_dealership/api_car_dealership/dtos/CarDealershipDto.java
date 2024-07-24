package com.car_dealership.api_car_dealership.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CarDealershipDto {

    @NotBlank
    private String modelCar;

    @NotBlank
    private String modelYear;

    @NotBlank
    @Size(max = 8)
    private String plateNumber;

    @NotBlank
    private String colorCar;

    @NotBlank
    private String brandCar;

    @NotBlank
    private String driverLicenseNumber;

    @NotBlank
    private String priceCar;

    @NotBlank
    private String responsibleName;


    public @NotBlank String getModelCar() {
        return modelCar;
    }

    public void setModelCar(@NotBlank String modelCar) {
        this.modelCar = modelCar;
    }

    public @NotBlank String getModelYear() {
        return modelYear;
    }

    public void setModelYear(@NotBlank String modelYear) {
        this.modelYear = modelYear;
    }

    public @NotBlank @Size(max = 8) String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(@NotBlank @Size(max = 8) String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public @NotBlank String getColorCar() {
        return colorCar;
    }

    public void setColorCar(@NotBlank String colorCar) {
        this.colorCar = colorCar;
    }

    public @NotBlank String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(@NotBlank String brandCar) {
        this.brandCar = brandCar;
    }

    public @NotBlank String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(@NotBlank String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public @NotBlank String getPriceCar() {
        return priceCar;
    }

    public void setPriceCar(@NotBlank String priceCar) {
        this.priceCar = priceCar;
    }

    public @NotBlank String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(@NotBlank String responsibleName) {
        this.responsibleName = responsibleName;
    }

}
