package com.example.demo.Repositories;


import com.example.demo.models.Customer;
import com.example.demo.models.CustomerStatus;
import com.example.demo.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    List<Customer> findByCustomerName(String anaLopez);

    List<Customer> findByCustomerStatus(CustomerStatus status);

    Customer save(Customer c);
}
