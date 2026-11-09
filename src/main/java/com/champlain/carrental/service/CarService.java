package com.champlain.carrental.service;

import com.champlain.carrental.dto.CarRequestDTO;
import com.champlain.carrental.entity.Car;
import com.champlain.carrental.exception.ResourceNotFoundException;
import com.champlain.carrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + id));
    }

    public Car createCar(CarRequestDTO dto) {
        Car car = new Car();
        car.setMake(dto.getMake());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setLicensePlate(dto.getLicensePlate());
        car.setDailyRate(dto.getDailyRate());
        car.setStatus(dto.getStatus());
        return carRepository.save(car);
    }

    public Car updateCar(Long id, CarRequestDTO dto) {
        Car existingCar = getCarById(id); // Throws 404 if not found

        existingCar.setMake(dto.getMake());
        existingCar.setModel(dto.getModel());
        existingCar.setYear(dto.getYear());
        existingCar.setLicensePlate(dto.getLicensePlate());
        existingCar.setDailyRate(dto.getDailyRate());
        existingCar.setStatus(dto.getStatus());

        return carRepository.save(existingCar);
    }

    public void deleteCar(Long id) {
        Car car = getCarById(id); // Throws 404 if not found
        carRepository.delete(car);
    }
}