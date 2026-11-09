package com.champlain.carrental.RentaslManagment.presentationlayer;


import com.champlain.carrental.RentaslManagment.datalayer.Rental;
import com.champlain.carrental.RentaslManagment.businesslogiclayer.RentalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @GetMapping
    public ResponseEntity<List<Rental>> getAllRentals() {
        return ResponseEntity.ok(rentalService.getAllRentals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getRentalById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getRentalById(id));
    }

    @PostMapping
    public ResponseEntity<Rental> createRental(@Valid @RequestBody RentalRequestDTO rentalDto) {
        Rental createdRental = rentalService.createRental(rentalDto);
        return new ResponseEntity<>(createdRental, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> updateRental(@PathVariable Long id, @Valid @RequestBody RentalRequestDTO rentalDto) {
        Rental updatedRental = rentalService.updateRental(id, rentalDto);
        return ResponseEntity.ok(updatedRental);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRental(@PathVariable Long id) {
        rentalService.deleteRental(id);
        return ResponseEntity.noContent().build();
    }
}