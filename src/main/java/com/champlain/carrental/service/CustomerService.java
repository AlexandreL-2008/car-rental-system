package com.champlain.carrental.service;

import com.champlain.carrental.dto.CustomerRequestDTO;
import com.champlain.carrental.entity.Customer;
import com.champlain.carrental.exception.ResourceNotFoundException;
import com.champlain.carrental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    public Customer createCustomer(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setDriverLicenseNumber(dto.getDriverLicenseNumber());
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, CustomerRequestDTO dto) {
        Customer existingCustomer = getCustomerById(id); // Throws 404 if not found

        existingCustomer.setFirstName(dto.getFirstName());
        existingCustomer.setLastName(dto.getLastName());
        existingCustomer.setEmail(dto.getEmail());
        existingCustomer.setDriverLicenseNumber(dto.getDriverLicenseNumber());

        return customerRepository.save(existingCustomer);
    }

    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id); // Throws 404 if not found
        customerRepository.delete(customer);
    }
}