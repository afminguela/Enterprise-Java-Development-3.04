package com.example.demo.Repositories;

import com.example.demo.models.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightBookingRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findByAircraftContains(String aircraft);
}
