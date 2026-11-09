package com.champlain.carrental.CarManagment.presentationlayer;

import com.champlain.carrental.CarManagment.datalayer.Car;
import com.champlain.carrental.CarManagment.businesslogiclayer.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody CarRequestDTO carDto) {
        Car createdCar = carService.createCar(carDto);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @Valid @RequestBody CarRequestDTO carDto) {
        Car updatedCar = carService.updateCar(id, carDto);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }
}