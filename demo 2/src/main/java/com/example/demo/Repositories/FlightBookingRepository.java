package com.example.demo.Repositories;

import com.example.demo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<Flight, Long> {
}
