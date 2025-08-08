package com.example.demo.Repositories;


import com.example.demo.models.Customer;
import com.example.demo.models.CustomerStatus;
import com.example.demo.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Flight, Integer> {


    List<Customer> findByCustomerName(String anaLopez);

    List<Customer> findByCustomerStatus(CustomerStatus status);

    Customer save(Customer c);
}
