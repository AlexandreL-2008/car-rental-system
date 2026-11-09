package com.champlain.carrental.CarManagment.presentationlayer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CarRequestDTO {
    @NotBlank(message = "Make is required")
    private String make;

    @NotBlank(message = "Model is required")
    private String model;

    @NotNull(message = "Year is required")
    @Min(value = 1900, message = "Year must be valid")
    private Integer year;

    @NotBlank(message = "License plate is required")
    private String licensePlate;

    @NotNull(message = "Daily rate is required")
    @Positive(message = "Daily rate must be greater than zero")
    private Double dailyRate;

    @NotBlank(message = "Status is required")
    private String status;

    // Getters and Setters
    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public String getLicensePlate() { return licensePlate; }
    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public Double getDailyRate() { return dailyRate; }
    public void setDailyRate(Double dailyRate) { this.dailyRate = dailyRate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}