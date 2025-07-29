package com.example.demo.Repositories;


import com.example.demo.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Flight, Long> {
}
