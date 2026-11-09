package com.champlain.carrental.service;

import com.champlain.carrental.dto.RentalRequestDTO;
import com.champlain.carrental.entity.Car;
import com.champlain.carrental.entity.Customer;
import com.champlain.carrental.entity.Rental;
import com.champlain.carrental.exception.ResourceNotFoundException;
import com.champlain.carrental.repository.CarRepository;
import com.champlain.carrental.repository.CustomerRepository;
import com.champlain.carrental.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CarRepository carRepository;

    public List<Rental> getAllRentals() {
        return rentalRepository.findAll();
    }

    public Rental getRentalById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rental not found with id: " + id));
    }

    public Rental createRental(RentalRequestDTO dto) {
        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + dto.getCustomerId()));

        Car car = carRepository.findById(dto.getCarId())
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + dto.getCarId()));

        Rental rental = new Rental();
        rental.setCustomer(customer);
        rental.setCar(car);
        rental.setStartDate(dto.getStartDate());
        rental.setEndDate(dto.getEndDate());
        rental.setStatus(dto.getStatus());

        // Calculate total cost based on daily rate and duration
        long days = ChronoUnit.DAYS.between(dto.getStartDate(), dto.getEndDate());
        if (days <= 0) {
            days = 1; // Minimum 1-day charge safeguard
        }
        rental.setTotalCost(days * car.getDailyRate());

        // Update car status to RENTED
        car.setStatus("RENTED");
        carRepository.save(car);

        return rentalRepository.save(rental);
    }

    public Rental updateRental(Long id, RentalRequestDTO dto) {
        Rental existingRental = getRentalById(id);

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + dto.getCustomerId()));

        Car car = carRepository.findById(dto.getCarId())
                .orElseThrow(() -> new ResourceNotFoundException("Car not found with id: " + dto.getCarId()));

        existingRental.setCustomer(customer);
        existingRental.setCar(car);
        existingRental.setStartDate(dto.getStartDate());
        existingRental.setEndDate(dto.getEndDate());
        existingRental.setStatus(dto.getStatus());

        long days = ChronoUnit.DAYS.between(dto.getStartDate(), dto.getEndDate());
        if (days <= 0) {
            days = 1;
        }
        existingRental.setTotalCost(days * car.getDailyRate());

        return rentalRepository.save(existingRental);
    }

    public void deleteRental(Long id) {
        Rental rental = getRentalById(id);

        // When rental is deleted/canceled, free the car back up
        Car car = rental.getCar();
        if (car != null) {
            car.setStatus("AVAILABLE");
            carRepository.save(car);
        }

        rentalRepository.delete(rental);
    }
}